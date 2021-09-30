package com.refresh.pos.ui.inventory;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentIntegratorSupportV4;
import com.google.zxing.integration.android.IntentResult;
import com.refresh.pos.R;
import com.refresh.pos.domain.inventory.Inventory;
import com.refresh.pos.domain.inventory.Product;
import com.refresh.pos.domain.inventory.ProductCatalog;
import com.refresh.pos.domain.sale.Register;
import com.refresh.pos.techicalservices.DatabaseExecutor;
import com.refresh.pos.techicalservices.Demo;
import com.refresh.pos.techicalservices.NoDaoSetException;
import com.refresh.pos.ui.CreAbsActivity;
import com.refresh.pos.ui.MainActivity;
import com.refresh.pos.ui.component.ButtonAdapter;
import com.refresh.pos.ui.component.UpdatableFragment;
import com.refresh.printerhelper.BaseApp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * UI for Inventory, shows list of Product in the ProductCatalog.
 * Also use for a sale process of adding Product into sale.
 *
 * @author Refresh Team
 */
@SuppressLint("ValidFragment")
public class InventoryFragment extends UpdatableFragment implements CreAbsActivity {


    private Realm uiThreadRealm;
    protected static final int SEARCH_LIMIT = 0;
    private ListView inventoryListView;
    private ProductCatalog productCatalog;
    List<Map<String, String>> inventoryList;
    private Button addProductButton;
    private EditText searchBox;
    private Button scanButton;

    private ViewPager viewPager;
    private Register register;
    private MainActivity main;

    private UpdatableFragment saleFragment;
    private Resources res;

    public InventoryFragment(UpdatableFragment saleFragment) {
        super();
        this.saleFragment = saleFragment;
    }

    /**
     * Initializing the realm objects / table references
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        uiThreadRealm = Realm.getInstance(Realm.getDefaultConfiguration());
        realmProducts = uiThreadRealm.where(Product.class).findAllAsync();
        realmProducts.addChangeListener(listener);
        //
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            productCatalog = Inventory.getInstance().getProductCatalog();
            register = Register.getInstance();
        } catch (NoDaoSetException e) {
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.layout_inventory, container, false);

        res = getResources();
        inventoryListView = (ListView) view.findViewById(R.id.productListView);
        addProductButton = (Button) view.findViewById(R.id.addProductButton);
        scanButton = (Button) view.findViewById(R.id.scanButton);
        searchBox = (EditText) view.findViewById(R.id.searchBox);

        main = (MainActivity) getActivity();
        viewPager = main.getViewPager();

        initUI();
        return view;
    }

    private void initUI() {
        addProductButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showPopup(v);
            }
        });
        searchBox.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (s.length() >= SEARCH_LIMIT) {
                    search();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        inventoryListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int position, long mylng) {
                int id = Integer.parseInt(inventoryList.get(position).get("id").toString());
//                TODO://
                register.addItem(realmProducts.where().equalTo("id",id).findFirst(), 1);
                saleFragment.update();
                viewPager.setCurrentItem(1);
            }
        });

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegratorSupportV4 scanIntegrator = new IntentIntegratorSupportV4(InventoryFragment.this);
                scanIntegrator.initiateScan();
            }
        });
    }

    private void showList(List<Product> list) {
        inventoryList = new ArrayList<Map<String, String>>();
        for (Product product : list) {
            inventoryList.add(product.toMap());
        }

        ButtonAdapter sAdap = new ButtonAdapter(getActivity().getBaseContext(), inventoryList,
                R.layout.listview_inventory, new String[]{"name"}, new int[]{R.id.name}, R.id.optionView, "id");
        inventoryListView.setAdapter(sAdap);
    }

    private void search() {
        String search = searchBox.getText().toString();

        if (search.equals("/demo")) {
            testAddProduct();
            searchBox.setText("");
        } else if (search.equals("/clear")) {
            DatabaseExecutor.getInstance().dropAllData();
            searchBox.setText("");
        } else if (search.equals("")) {
//     		showList(productCatalog.getAllProduct());
            int size = realmProducts.size();
            if (size <= 0) {
                productCatalog.searchProductFromNetwork("", this);
            }else{
                showList( realmProducts);
            }
        } else {
            try{
                showList( realmProducts.where().contains ("name", search).beginsWith  ("id",search) .findAllAsync() );
            }catch(Exception e){e.printStackTrace();}

//            List<Product> result = productCatalog.searchProduct(search);
//            showList(result);
//            if (result.isEmpty()) {
//                //TODO
//            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(
                requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            searchBox.setText(scanContent);
        } else {
            Toast.makeText(getActivity().getBaseContext(), res.getString(R.string.fail),
                    Toast.LENGTH_SHORT).show();
        }
    }

    protected void testAddProduct() {
        Demo.testProduct(getActivity());
        Toast.makeText(getActivity().getBaseContext(), res.getString(R.string.success),
                Toast.LENGTH_SHORT).show();
    }

    public void showPopup(View anchorView) {
        AddProductDialogFragment newFragment = new AddProductDialogFragment(InventoryFragment.this);
        newFragment.show(getFragmentManager(), "");
    }

    @Override
    public void update() {
        search();
    }

    @Override
    public void onResume() {
        super.onResume();
        update();
    }

    @Override
    public int onRequestSuccess(final String code, final String msg) {
        try {
            Log.e("Fragment Inventory ","ON Success ==>"+code+"===>"+"   msg==>"+msg);

            if (code.equalsIgnoreCase("product_list"))
            {
                JSONArray jsonArray = new JSONArray(msg);
                int count = jsonArray.length();
                final List<Product> productList = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    String name = jsonObject.getString("item_name");
                    String barcode = jsonObject.getString("item_code");
                    double salePrice = jsonObject.getDouble("sales_price");
                    Product product = new Product(id, name, barcode, salePrice);
                    productList.add(product);
                }
                if (productList.size() > 0) {
                    Log.e("Fragment Inventory ","IF Part on result onRequestSuccess()");

                    int size = realmProducts.size();
                    if (size > 0) {
                        uiThreadRealm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                Log.e("Fragment Inventory ","Deleting old record onRequestSuccess()");
                                uiThreadRealm.where(Product.class).findAllAsync().deleteAllFromRealm();
                            }
                        });
                        uiThreadRealm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                Log.e("Fragment Inventory ","Deleting old record onRequestSuccess()");
                                uiThreadRealm.insertOrUpdate(productList);

                            }
                        });
                    }else {
                        Log.e("Fragment Inventory ","Inserting record first time onRequestSuccess()");

                        uiThreadRealm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                Log.e("Fragment Inventory ","Deleting old record onRequestSuccess()");
                                uiThreadRealm.insertOrUpdate(productList);

                            }
                        });

                    }
                } else {
                    Log.e("Fragment Inventory ","else Part on result");

                    int size = realmProducts.size();
                    if (size > 0) {
                        showList(realmProducts);
                    }
                }
//                below lines commented due to realm integration
//                showList(productList);
//                productCatalog.setResultFromNetwork(productList);
            }
            else if (code.equalsIgnoreCase("product_delete")) {




            }
        } catch (JSONException e) {
            Log.e("InventoryFragment", e.getLocalizedMessage());
        }
        return 0;
    }

    @Override
    public int onRequestFail(String code, String msg) {
        Toast.makeText(main, msg, Toast.LENGTH_LONG).show();
        if (code.equalsIgnoreCase("product_list")) {
        int size = realmProducts.size();
        if (size > 0) {
            showList(realmProducts);
        }
        }
        return 0;
    }

    @Override
    public void showProgress(boolean bshow) {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        // the ui thread realm uses asynchronous transactions, so we can only safely close the realm
        // when the activity ends and we can safely assume that those transactions have completed
        try {
            realmProducts.removeChangeListener(listener);
            uiThreadRealm.close();
        } catch (Exception e) {

        }

    }

    /**
     * Realm product table reference.
     */
    private RealmResults<Product> realmProducts;

    private final RealmChangeListener<RealmResults<Product>> listener = new RealmChangeListener<RealmResults<Product>>() {
        @Override
        public void onChange(RealmResults<Product> products) {
            try {
                int size = products.size();
                Log.e("Fragment Inventory ","the size of Products table "+size);
                if (size > 0) {
                    showList(products);
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    };

}
package com.refresh.pos.ui;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.refresh.pos.R;
import com.refresh.pos.domain.LanguageController;
import com.refresh.pos.domain.inventory.Inventory;
import com.refresh.pos.domain.inventory.Product;
import com.refresh.pos.domain.inventory.ProductCatalog;
import com.refresh.pos.network.CreHttpRequest;
import com.refresh.pos.techicalservices.NoDaoSetException;
import com.refresh.pos.ui.component.UpdatableFragment;
import com.refresh.pos.ui.inventory.InventoryFragment;
import com.refresh.pos.ui.inventory.ProductDetailActivity;
import com.refresh.pos.ui.sale.ReportFragment;
import com.refresh.pos.ui.sale.SaleFragment;
import com.refresh.printerhelper.BaseActivity;
import com.refresh.printerhelper.BaseApp;
import com.refresh.printerhelper.FunctionActivity;
import com.refresh.printerhelper.SettingActivity;

import io.realm.Realm;

/**
 * This UI loads 3 main pages (Inventory, Sale, Report)
 * Makes the UI flow by slide through pages using ViewPager.
 *
 * @author Refresh Team
 */
@SuppressLint("NewApi")
public class MainActivity extends BaseActivity implements CreAbsActivity {

    private static boolean SDK_SUPPORTED;
    private ViewPager viewPager;
    private ProductCatalog productCatalog;
    private String productId;
    private Product product;
    private PagerAdapter pagerAdapter;
    private Resources res;

    @SuppressLint("NewApi")
    private void initiateActionBar() {
        if (SDK_SUPPORTED) {
            ActionBar actionBar = getActionBar();

            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            ActionBar.TabListener tabListener = new ActionBar.TabListener() {
                @Override
                public void onTabReselected(Tab tab, FragmentTransaction ft) {
                }

                @Override
                public void onTabSelected(Tab tab, FragmentTransaction ft) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(Tab tab, FragmentTransaction ft) {
                }
            };
            actionBar.addTab(actionBar.newTab().setText(res.getString(R.string.inventory))
                    .setTabListener(tabListener), 0, false);
            actionBar.addTab(actionBar.newTab().setText(res.getString(R.string.sale))
                    .setTabListener(tabListener), 1, true);
            actionBar.addTab(actionBar.newTab().setText(res.getString(R.string.report))
                    .setTabListener(tabListener), 2, false);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color
                        .parseColor("#73bde5")));
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        res = getResources();
        setContentView(R.layout.layout_main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        super.onCreate(savedInstanceState);
        SDK_SUPPORTED = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
        CreHttpRequest._context = this;
        initiateActionBar();
        FragmentManager fragmentManager = getSupportFragmentManager();
        pagerAdapter = new PagerAdapter(fragmentManager, res);
        viewPager.setAdapter(pagerAdapter);
        viewPager
                .addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        if (SDK_SUPPORTED)
                            getActionBar().setSelectedNavigationItem(position);
                    }
                });
        viewPager.setCurrentItem(1);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            openQuitDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                MainActivity.this);
        quitDialog.setTitle(res.getString(R.string.dialog_quit));
        quitDialog.setPositiveButton(res.getString(R.string.quit), new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        quitDialog.setNegativeButton(res.getString(R.string.no), new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        quitDialog.show();
    }

    public void optionOnClickHandler(View view) {
        viewPager.setCurrentItem(0);
        String id = view.getTag().toString();
        productId = id;
        try {
            productCatalog = Inventory.getInstance().getProductCatalog();
        } catch (NoDaoSetException e) {
            e.printStackTrace();
        }
        try{
       Realm  uiThreadRealm = Realm.getInstance(Realm.getDefaultConfiguration());
        product = uiThreadRealm.where(Product.class).equalTo("id",Integer.parseInt(productId)).findFirst();
        uiThreadRealm.close();
        }catch (Exception e){e.printStackTrace();}
//        product = productCatalog.getProductById(Integer.parseInt(productId));
        openDetailDialog();
    }

    private void openDetailDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(MainActivity.this);
        quitDialog.setTitle(product.getName());
        quitDialog.setPositiveButton(res.getString(R.string.remove), new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            openRemoveDialog();
            }
        });

        quitDialog.setNegativeButton(res.getString(R.string.product_detail), new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            Intent newActivity = new Intent(MainActivity.this,
                    ProductDetailActivity.class);
            newActivity.putExtra("id", productId);
            startActivity(newActivity);
            }
        });

        quitDialog.show();
    }

    private void openRemoveDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                MainActivity.this);
        quitDialog.setTitle(res.getString(R.string.dialog_remove_product));
        quitDialog.setPositiveButton(res.getString(R.string.no), new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        quitDialog.setNegativeButton(res.getString(R.string.remove), new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            productCatalog.suspendProductFromNetwork(product, MainActivity.this);
//            pagerAdapter.update(0);
            }
        });

        quitDialog.show();
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.lang_en:
                setLanguage("en");
                return true;
            case R.id.lang_th:
                setLanguage("th");
                return true;
            case R.id.lang_jp:
                setLanguage("jp");
                return true;
            //case R.id.menu_setting:
              //  startActivity(new Intent(this, FunctionActivity.class));
                //return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setLanguage(String localeString) {
        Locale locale = new Locale(localeString);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        LanguageController.getInstance().setLanguage(localeString);
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    public int onRequestSuccess(String code, final String msg) {
        try {
            if (code.equalsIgnoreCase("product_delete")) {
                final Realm  uiThreadRealm = Realm.getInstance(Realm.getDefaultConfiguration());
                uiThreadRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        try{
                            Log.e("Fragment Inventory ","Deleting Product from local db after delete success from network");
                            realm.where(Product.class).equalTo("id",Integer.parseInt(msg)).findFirst().deleteFromRealm();
                        }catch(Exception e){e.printStackTrace();                         }
                    }
                });
                uiThreadRealm.close();
//                this line was being used to delete local list item from catlog being shown in a single run
//                productCatalog.suspendProduct(Integer.parseInt(msg));
                pagerAdapter.update(0);
            }
        } catch (Exception e) {
            Log.e("MainActivity", "onRequestSuccess " + code + " ==> " + e.getLocalizedMessage());
        }

        return 0;
    }

    @Override
    public int onRequestFail(String code, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        return 0;
    }

    @Override
    public void showProgress(boolean bshow) {

    }
}

class PagerAdapter extends FragmentStatePagerAdapter {

    private UpdatableFragment[] fragments;
    private String[] fragmentNames;

    public PagerAdapter(FragmentManager fragmentManager, Resources res) {

        super(fragmentManager);

        UpdatableFragment reportFragment = new ReportFragment();
        UpdatableFragment saleFragment = new SaleFragment(reportFragment);
        UpdatableFragment inventoryFragment = new InventoryFragment(
                saleFragment);

        fragments = new UpdatableFragment[]{inventoryFragment, saleFragment,
                reportFragment};
        fragmentNames = new String[]{res.getString(R.string.inventory),
                res.getString(R.string.sale),
                res.getString(R.string.report)};

    }

    @Override
    public Fragment getItem(int i) {
        return fragments[i];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return fragmentNames[i];
    }

    public void update(int i) {
        fragments[i].update();
    }
}

package com.refresh.pos.ui.sale;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.refresh.pos.R;
import com.refresh.pos.domain.DateTimeStrategy;
import com.refresh.pos.domain.inventory.Product;
import com.refresh.pos.domain.sale.Sale;
import com.refresh.pos.domain.sale.SaleLedger;
import com.refresh.pos.techicalservices.NoDaoSetException;
import com.refresh.pos.ui.CreAbsActivity;
import com.refresh.pos.ui.component.UpdatableFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * UI for showing sale's record.
 * @author Refresh Team
 *
 */
public class ReportFragment extends UpdatableFragment implements CreAbsActivity {
	
	private SaleLedger saleLedger;
	List<Map<String, String>> saleList;
	private ListView saleLedgerListView;
	private TextView totalBox;
	private Spinner spinner;
	private Button previousButton;
	private Button nextButton;
	private TextView currentBox;
	private Calendar currentTime;
	private DatePickerDialog datePicker;
	
	public static final int DAILY = 0;
	public static final int WEEKLY = 1;
	public static final int MONTHLY = 2;
	public static final int YEARLY = 3;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		try {
			saleLedger = SaleLedger.getInstance();
		} catch (NoDaoSetException e) {
			e.printStackTrace();
		}
		
		View view = inflater.inflate(R.layout.layout_report, container, false);
		
		previousButton = (Button) view.findViewById(R.id.previousButton);
		nextButton = (Button) view.findViewById(R.id.nextButton);
		currentBox = (TextView) view.findViewById(R.id.currentBox);
		saleLedgerListView = (ListView) view.findViewById(R.id.saleListView);
		totalBox = (TextView) view.findViewById(R.id.totalBox);
		spinner = (Spinner) view.findViewById(R.id.spinner1);
		
		initUI();
		return view;
	}

	private void initUI() {
		currentTime = Calendar.getInstance();
		datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker view, int y, int m, int d) {
				currentTime.set(Calendar.YEAR, y);
				currentTime.set(Calendar.MONTH, m);
				currentTime.set(Calendar.DAY_OF_MONTH, d);
				update();
			}
		}, currentTime.get(Calendar.YEAR), currentTime.get(Calendar.MONTH), currentTime.get(Calendar.DAY_OF_MONTH));
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
		        R.array.period, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinner.setAdapter(adapter);
		spinner.setSelection(0);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener(){
			
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {	
				update();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) { }
			
		});
		
		currentBox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				datePicker.show();
			}
		});

		previousButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				addDate(-1);
			}
		});
		
		nextButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				addDate(1);
			}
		});
		
		saleLedgerListView.setOnItemClickListener(new OnItemClickListener() {
		      public void onItemClick(AdapterView<?> myAdapter, View myView, int position, long mylng) {
			String id = saleList.get(position).get("id").toString();
			Intent newActivity = new Intent(getActivity().getBaseContext(), SaleDetailActivity.class);
			newActivity.putExtra("id", id);
			startActivity(newActivity);
		      }     
		});
	}
	
	private void showList(List<Sale> list) {

		try {
			saleList = new ArrayList<Map<String, String>>();
			for (Sale sale : list) {
//			saleList.add(sale.toMap());
				saleList.add(sale.toMapDirectly());
			}

			SimpleAdapter sAdap = new SimpleAdapter(getActivity().getBaseContext(), saleList,
					R.layout.listview_report, new String[]{"id", "startTime", "total"},
					new int[]{R.id.sid, R.id.startTime, R.id.total});
			saleLedgerListView.setAdapter(sAdap);
		} catch (Exception e) {
			Log.e("ReportFragment", "exception in showList "+ e.getLocalizedMessage());
		}
	}

	@Override
	public void update() {
		int period = spinner.getSelectedItemPosition();
		List<Sale> list = null;
		Calendar cTime = (Calendar) currentTime.clone();
		Calendar eTime = (Calendar) currentTime.clone();
		
		if(period == DAILY){
			currentBox.setText(" [" + DateTimeStrategy.getSQLDateFormat(currentTime) +  "] ");
			currentBox.setTextSize(16);
		} else if (period == WEEKLY){
			while(cTime.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				cTime.add(Calendar.DATE, -1);
			}
			
			String toShow = " [" + DateTimeStrategy.getSQLDateFormat(cTime) +  "] ~ [";
			eTime = (Calendar) cTime.clone();
			eTime.add(Calendar.DATE, 7);
			toShow += DateTimeStrategy.getSQLDateFormat(eTime) +  "] ";
			currentBox.setTextSize(16);
			currentBox.setText(toShow);
		} else if (period == MONTHLY){
			cTime.set(Calendar.DATE, 1);
			eTime = (Calendar) cTime.clone();
			eTime.add(Calendar.MONTH, 1);
			eTime.add(Calendar.DATE, -1);
			currentBox.setTextSize(18);
			currentBox.setText(" [" + currentTime.get(Calendar.YEAR) + "-" + (currentTime.get(Calendar.MONTH)+1) + "] ");
		} else if (period == YEARLY){
			cTime.set(Calendar.DATE, 1);
			cTime.set(Calendar.MONTH, 0);
			eTime = (Calendar) cTime.clone();
			eTime.add(Calendar.YEAR, 1);
			eTime.add(Calendar.DATE, -1);
			currentBox.setTextSize(20);
			currentBox.setText(" [" + currentTime.get(Calendar.YEAR) +  "] ");
		}
		currentTime = cTime;
		saleLedger.getAllSaleDuringFromNetwork(cTime, eTime, this);
//		list = saleLedger.getAllSaleDuring(cTime, eTime);
//		double total = 0;
//		for (Sale sale : list)
//			total += sale.getTotal();
//
//		totalBox.setText(total + "");
//		showList(list);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		// update();
		// it shouldn't call update() anymore. Because super.onResume() 
		// already fired the action of spinner.onItemSelected()
	}
	
	private void addDate(int increment) {
		int period = spinner.getSelectedItemPosition();
		if (period == DAILY){
			currentTime.add(Calendar.DATE, 1 * increment);
		} else if (period == WEEKLY){
			currentTime.add(Calendar.DATE, 7 * increment);
		} else if (period == MONTHLY){
			currentTime.add(Calendar.MONTH, 1 * increment);
		} else if (period == YEARLY){
			currentTime.add(Calendar.YEAR, 1 * increment);
		}
		update();
	}

	@Override
	public int onRequestSuccess(String code, String msg) {
		try {
			JSONArray jsonArray = new JSONArray(msg);
			int count = jsonArray.length();
			List<Sale> saleList = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int id = jsonObject.getInt("id");
				String startTime = jsonObject.getString("date");
				double total = jsonObject.getDouble("total");
				double discount = jsonObject.getDouble("discount");
				long mobile = jsonObject.getLong("phone");
				Sale sale = new Sale(id, startTime, total);
				sale.setDiscount(discount);
				sale.setMobile(mobile);
				saleList.add(sale);
			}
			double total = 0;
			for (Sale sale : saleList)
				//total += sale.getTotal();
				total += sale.getTotalDirectly();

			totalBox.setText(total + "");
			saleLedger.setSalesFromNetwork(saleList);
			showList(saleList);
		} catch (JSONException e) {
			Log.e("ReportFragment", e.getLocalizedMessage());
		}

		return 0;
	}

	@Override
	public int onRequestFail(String code, String msg) {
		Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
		return 0;
	}

	@Override
	public void showProgress(boolean bshow) {

	}
}

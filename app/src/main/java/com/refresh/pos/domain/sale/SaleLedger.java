package com.refresh.pos.domain.sale;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.refresh.pos.config.Global;
import com.refresh.pos.network.CreHttpRequest;
import com.refresh.pos.techicalservices.NoDaoSetException;
import com.refresh.pos.techicalservices.sale.SaleDao;
import com.refresh.pos.ui.CreAbsActivity;

import io.realm.RealmList;

/**
 * Book that keeps sale record.
 * 
 * @author Refresh Team
 *
 */
public class SaleLedger {
	
	private static SaleLedger instance = null;
	private static SaleDao saleDao = null;
	
	private SaleLedger() throws NoDaoSetException {
		if (!isDaoSet()) {
			throw new NoDaoSetException();
		}
	}
	
	public static boolean isDaoSet() {
		return saleDao != null;
	}
	
	public static SaleLedger getInstance() throws NoDaoSetException {
		if (instance == null) instance = new SaleLedger();
		return instance;
	}

	public static void setSaleDao(SaleDao dao) {
		saleDao = dao;	
	}
	
	public RealmList<QuickLoadSale> getAllSale() {
		return saleDao.getAllSale();
	}
	
	public Sale getSaleById(int id) {
		return saleDao.getSaleById(id);
	}

	public void clearSaleLedger() {
		saleDao.clearSaleLedger();
	}

	public  RealmList<QuickLoadSale> getAllSaleDuring(Calendar start, Calendar end) {
		return saleDao.getAllSaleDuring(start, end);
	}

	public void getAllSaleDuringFromNetwork(Calendar start, Calendar end, CreAbsActivity receiver) {
		HashMap<String, String> params = new HashMap<>();
		params.put("method", "getInvoices");
		params.put("key", Global._papiKey);
		params.put("ctime", String.valueOf(start.getTime()));
		params.put("etime", String.valueOf(end.getTime()));
		CreHttpRequest.doHttpPost(Global._pserverUrl, params,receiver);
	}

	public void setSalesFromNetwork(List<Sale> sales) {
		saleDao.setSales(sales);
	}
}


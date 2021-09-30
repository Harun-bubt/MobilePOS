package com.refresh.pos.techicalservices.sale;

import java.util.Calendar;
import java.util.List;

import com.refresh.pos.domain.inventory.LineItem;
import com.refresh.pos.domain.sale.QuickLoadSale;
import com.refresh.pos.domain.sale.Sale;

import io.realm.RealmList;

/**
 * DAO for Sale process.
 * 
 * @author Refresh Team
 *
 */
public interface SaleDao {

	Sale initiateSale(String startTime);

	void endSale(Sale sale, String endTime,Long mobile,Double discount);

	int addLineItem(int saleId, LineItem lineItem);
	
	RealmList<QuickLoadSale> getAllSale();

	Sale getSaleById(int id);

	void clearSaleLedger();

	RealmList<LineItem> getLineItem(int saleId);

	void updateLineItem(int saleId, LineItem lineItem);

	RealmList<QuickLoadSale> getAllSaleDuring(Calendar start, Calendar end);
	
	void cancelSale(Sale sale,String endTime);

	void removeLineItem(int id);

	void setSales(List<Sale> sales);
}

package com.refresh.pos.domain.sale;

import com.refresh.pos.config.Global;
import com.refresh.pos.domain.DateTimeStrategy;
import com.refresh.pos.domain.inventory.Inventory;
import com.refresh.pos.domain.inventory.LineItem;
import com.refresh.pos.domain.inventory.Product;
import com.refresh.pos.domain.inventory.Stock;
import com.refresh.pos.network.CreHttpRequest;
import com.refresh.pos.techicalservices.NoDaoSetException;
import com.refresh.pos.techicalservices.sale.SaleDao;
import com.refresh.pos.ui.CreAbsActivity;

import java.util.HashMap;

import io.realm.Realm;

/**
 * Handles all Sale processes.
 *
 * @author Refresh Team
 *
 */
public class Register {
	private static Register instance = null;
	private static SaleDao saleDao = null;
	private static Stock stock = null;
	
	private Sale currentSale;
	
	private Register() throws NoDaoSetException {
		if (!isDaoSet()) {
			throw new NoDaoSetException();
		}
		stock = Inventory.getInstance().getStock();
		
	}
	
	public static boolean isDaoSet() {
		return saleDao != null;
	}
	
	public static Register getInstance() throws NoDaoSetException {
		if (instance == null) instance = new Register();
		return instance;
	}

	public static void setSaleDao(SaleDao dao) {
		saleDao = dao;	
	}
	
	public void initiateSale(String startTime) {
	 saleDao.initiateSale(startTime);

	}
	
	public LineItem addItem(Product product, int quantity) {
//		if (quantity <= 0 || currentSale == null)
//			return -1;
		if (currentSale == null)
			initiateSale(DateTimeStrategy.getCurrentTime());
		
		LineItem lineItem = currentSale.addLineItem(product, quantity);
		
		if (lineItem.getId() == LineItem.UNDEFINED) {
			int lineId = saleDao.addLineItem(currentSale.getId(), lineItem);
			lineItem.setId(lineId);
		} else {
			saleDao.updateLineItem(currentSale.getId(), lineItem);
		}
		
		return lineItem;
	}
	
	public double getTotal() {
		if (currentSale == null) return 0;
		return currentSale.gettender();
	}

	public void endSale(String endTime,Long mobile,double discount) {
		if (currentSale != null) {
			currentSale.setMobile(mobile);
			currentSale.setDiscount(discount);
			saleDao.endSale(currentSale, endTime,mobile,discount);
				HashMap<String, String> params = new HashMap<>();
				//////////////////////////////////////////////////////////////////////////////
				params.put("key", Global._papiKey);
				params.put("user_id", "");
				params.put("account", "");
				params.put("duedate", endTime);
				params.put("subtotal", String.valueOf(currentSale.getTotal()));
				params.put("discount_type","");
				params.put("iid", "");
				params.put("nd", "");
				params.put("r", "");
				params.put("ptoken", "");
				params.put("vtoken", "");
				params.put("notes", "");
				params.put("method", "insertSysInvoice");
				params.put("paymentmethod", "");
				params.put("status", currentSale.getStatus());
				params.put("taxrate2", "");
				params.put("taxrate", "");
				params.put("total", String.valueOf(currentSale.getTotal()));
				params.put("tax2", "");
				params.put("tax", "");
				params.put("taxname", "");
				params.put("credit", "");
				params.put("discount", String.valueOf( currentSale.getdiscount()));
				params.put("discount_value", String.valueOf( currentSale.getdiscount()));

				CreHttpRequest.doHttpPost(Global._pserverUrl, params, new CreAbsActivity() {
					@Override
					public int onRequestSuccess(String code, String msg) {
                             counter=0;
                             postItems();
						return 0;
					}

					@Override
					public int onRequestFail(String code, String msg) {
						return 0;
					}

					@Override
					public void showProgress(boolean bshow) {

					}
				});






		}
	}

	int counter = 0  ;
	private void postItems(){

		if(counter >= currentSale.getAllLineItem().size())
		{
			currentSale = null;
			return;
		}
		try{
			LineItem item = currentSale.getAllLineItem().get(counter);
			HashMap<String, String> params = new HashMap<>();
			//////////////////////////////////////////////////////////////////////////////
			params.put("key", Global._papiKey);
			params.put("method", "insertSysInvoiceItems");
			params.put("user_id", "");
			params.put("invoiceid", String.valueOf(currentSale.getId()));
			params.put("itemcode", String.valueOf(item.getId()));
			params.put("description", String.valueOf(""));
			params.put("qty",String.valueOf(item.getQuantity()));
			params.put("amount",String.valueOf(item.getPriceAtSale()));
			params.put("taxed", "");
			params.put("taxamount","");
			params.put("total", String.valueOf(item.getTotalPriceAtSale()));
			params.put("duedate",String.valueOf(currentSale.getEndTime()));

			CreHttpRequest.doHttpPost(Global._pserverUrl, params, new CreAbsActivity() {
				@Override
				public int onRequestSuccess(String code, String msg) {
					counter+=1;
					postItems();
					return 0;
				}

				@Override
				public int onRequestFail(String code, String msg) {
					return 0;
				}

				@Override
				public void showProgress(boolean bshow) {

				}
			});
//							for(LineItem line : currentSale.getAllLineItem()){
//								stock.updateStockSum(line.getProduct().getId(), line.getQuantity());
//							}
		}catch (Exception e){e.printStackTrace();}
	}

	public Sale getCurrentSale() {
		if (currentSale == null)
			initiateSale(DateTimeStrategy.getCurrentTime());
		return currentSale;
	}
	
	public boolean setCurrentSale(int id) {
//		if (currentSale == null)
//			initiateSale(DateTimeStrategy.getCurrentTime());
//		return currentSale;
		try {





			currentSale = Realm.getDefaultInstance().where(Sale.class).equalTo("id",String.valueOf( id)).findFirst();

		}catch (Exception e ){e.printStackTrace();}
		return false;
	}
	public boolean hasSale(){
		if(currentSale == null)return false;
		return true;
	}
	
	public void cancleSale() {
		if (currentSale != null){
			saleDao.cancelSale(currentSale,DateTimeStrategy.getCurrentTime());
			currentSale = null;
		}
	}
	public void updateItem(int saleId, LineItem lineItem, int quantity, double priceAtSale) {
		lineItem.setUnitPriceAtSale(priceAtSale);
		lineItem.setQuantity(quantity);
		saleDao.updateLineItem(saleId, lineItem);
		currentSale.updateTotalAmount();
	}

	public void removeItem(LineItem lineItem) {
		saleDao.removeLineItem(lineItem.getId());
		currentSale.removeItem(lineItem);
		if (currentSale.getAllLineItem().isEmpty()) {
			cancleSale();
		}
	}
	
}
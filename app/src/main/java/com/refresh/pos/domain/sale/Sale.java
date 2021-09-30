package com.refresh.pos.domain.sale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.refresh.pos.domain.inventory.LineItem;
import com.refresh.pos.domain.inventory.Product;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Sale represents sale operation.
 * 
 * @author Refresh Team
 *
 */
public class Sale extends RealmObject {
	@PrimaryKey
	private  int id;
	private String startTime;
	private String endTime;
	private String status;
	private Double discount = 0.d;
	private Double total = 0.d;
	private Long mobile = 0L;
	private RealmList<LineItem> items = new RealmList<>();

	public Sale() {

	}

	public Sale(int id, String startTime, Double total) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = startTime;
		this.total = total;
	}

	public Sale(int id, String startTime,Long mobile,Double discount) {
		this(id, startTime, startTime, "",mobile,discount, new RealmList<LineItem>());
	}
	
	public Sale(int id, String startTime, String endTime, String status,Long mobile,Double discount, RealmList<LineItem> items) {
		this.id = id;
		this.startTime = startTime;
		this.status = status;
		this.endTime = endTime;
		this.items = items;
		this.mobile = mobile;
		this.discount = discount;
		updateTotalAmount();
	}
	
	public List<LineItem> getAllLineItem(){
		return items;
	}
	
	public LineItem addLineItem(Product product, int quantity) {
		
		for (LineItem lineItem : items) {
			if (lineItem.getProduct().getId() == product.getId()) {
				lineItem.addQuantity(quantity);
				updateTotalAmount();;
				return lineItem;
			}
		}
		
		LineItem lineItem = new LineItem(product, quantity);
		items.add(lineItem);
		updateTotalAmount();;
		return lineItem;
	}
	
	public int size() {
		return items.size();
	}
	
	public LineItem getLineItemAt(int index) {
		if (index >= 0 && index < items.size())
			return items.get(index);
		return null;
	}

	public double getTotalDirectly() {
		return total == null ? 0.d : total;
	}

	public double getTotal() {
		double amount = 0;
		for(LineItem lineItem : items) {
			amount += lineItem.getTotalPriceAtSale();
		}
		return amount;
	}

	public double getcgst() {
		double tax = 0.09;
		double cgst = 0;
//		double amount = 0;
//		for (LineItem lineItem : items) {
//			amount += lineItem.getTotalPriceAtSale();
//		}
//		if (amount < 500){
//			tax=0.025;
//		}
//		cgst=amount*tax;
		if (total < 500) {
			tax = 0.025;
		}
		cgst = total * tax;
		return cgst;
	}

	public double getdiscount(){
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public double gettender(){
//		double amount=getTotal();
		double amount=getTotalDirectly();
		//double sgst=getcgst();
		//double cgst=getcgst();
		//double tender=amount+sgst+cgst;
		double tender=amount;
		tender = Double.parseDouble(String.format("%.2f",tender));
		return tender;
	}
	public long mobile(){
		return mobile != null ? mobile : 0;
	}

	public int getId() {
		return id;
	}

	public String getStartTime() {
		return startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}

	public String getPayment() {
		return "CASH";
	}

	public String getStatus() {
		return status;
	}
	public int getOrders() {
		int orderCount = 0;
		for (LineItem lineItem : items) {
			orderCount += lineItem.getQuantity();
		}
		return orderCount;
	}

	public Map<String, String> toMap() {	
		Map<String, String> map = new HashMap<String, String>();
		map.put("id",id + "");
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("status", getStatus());
//		map.put("tender", String.valueOf(gettender())+"");
		map.put("total", getTotal() + "");
		map.put("orders", getOrders() + "");
		
		return map;
	}

	public Map<String, String> toMapDirectly() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id",id + "");
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("status", getStatus());
//		map.put("tender", String.valueOf(gettender())+"");
		map.put("total", getTotalDirectly() + "");
		map.put("orders", 0 + "");

		return map;
	}

	public void removeItem(LineItem lineItem) {
		items.remove(lineItem);
		updateTotalAmount();
	}

	public void updateTotalAmount() {
		this.total = getTotal();
	}

}
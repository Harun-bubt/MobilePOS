package com.refresh.pos.domain.sale;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Sale that loads only total and orders.
 * It's for overview report that doesn't need LineItem's information.
 * NOTE: This Sale instance throws NullPointerException
 * when calling method that involve with LineItem.
 * 
 * @author Refresh Team
 *
 */
public class QuickLoadSale extends RealmObject {
	@PrimaryKey
	private int id;
	private Double total;
	private Integer orders;
	private Long mobile;
	private Double discount;
	private Sale sale;

	public QuickLoadSale() {
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	/**
	 * 
	 * @param id ID of this sale.
	 * @param startTime
	 * @param endTime
	 * @param status
	 * @param total
	 * @param orders numbers of lineItem in this Sale.
	 */
	public QuickLoadSale(int id, String startTime, String endTime, String status,Long mobile,Double discount, Double total, Integer orders) {
//		super(id, startTime, endTime, status, (long) 0,0.00, null);
		this.sale = new Sale(id,startTime,endTime,status,(long) 0,0.00, null);
		this.total = total;
		this.orders = orders;
		this.mobile=mobile;
		this.discount=discount;
	}
	

	public int getOrders() {
		return orders;
	}
	

	public double getTotal() {
		return total;
	}

}

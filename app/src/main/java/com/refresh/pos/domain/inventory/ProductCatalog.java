package com.refresh.pos.domain.inventory;

import java.util.HashMap;
import java.util.List;

import com.refresh.pos.config.Global;
import com.refresh.pos.network.CreHttpRequest;
import com.refresh.pos.techicalservices.inventory.InventoryDao;
import com.refresh.pos.ui.CreAbsActivity;

/**
 * Book that keeps list of Product.
 * 
 * @author Refresh Team
 *
 */


public class ProductCatalog {

	private InventoryDao inventoryDao;

	public ProductCatalog(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	public boolean addProduct(String name, String barcode, double salePrice) {
		Product product = new Product(name, barcode, salePrice);		
		int id = inventoryDao.addProduct(product);
		return id != -1;
	}

	public boolean addProduct(String id, String name, String barcode, String salePrice) {
		try {
			Product product = new Product(name, barcode, Double.parseDouble(salePrice));
			product.setId(Integer.parseInt(id));
			return inventoryDao.addProduct(product) != -1;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean editProduct(Product product) {
		boolean respond = inventoryDao.editProduct(product);
		return respond;
	}
		
	public Product getProductByBarcode(String barcode) {
		return inventoryDao.getProductByBarcode(barcode);
	}
	
	public Product getProductById(int id) {
		return inventoryDao.getProductById(id);
	}
	
	public List<Product> getAllProduct() {
		return inventoryDao.getAllProduct();
	}

	public List<Product> getProductByName(String name) {
		return inventoryDao.getProductByName(name);
	}

	public List<Product> searchProduct(String search) {
		return inventoryDao.searchProduct(search);
	}

	public void clearProductCatalog() {
		inventoryDao.clearProductCatalog();
	}
	
	public void suspendProduct(Product product) {
		inventoryDao.suspendProduct(product);
	}

	public void suspendProduct(int id) {
		Product product = inventoryDao.getProductById(id);
		if (product != null) {
			this.suspendProduct(product);
		}
	}

	public void addProductFromNetwork(String item_name, String item_code, String sales_price,
									  String quantity, CreAbsActivity receiver) {
		HashMap<String, String> params = new HashMap<>();
		params.put("method", "product_add");
		params.put("key", Global._papiKey);
		params.put("item_name", item_name);
		params.put("item_code", item_code);
		params.put("sales_price", sales_price);
		params.put("quantity", quantity);
		CreHttpRequest.doHttpPost(Global._pserverUrl, params,receiver);
	}

	public void suspendProductFromNetwork(Product product, CreAbsActivity receiver) {
		HashMap<String, String> params = new HashMap<>();
		params.put("method", "product_delete");
		params.put("key", Global._papiKey);
		params.put("id", product.getId() + "");
		CreHttpRequest.doHttpPost(Global._pserverUrl, params,receiver);
	}



	public void searchProductFromNetwork(String search, CreAbsActivity receiver) {
		HashMap<String, String> params = new HashMap<>();
		params.put("method", "product_list");
		params.put("key", Global._papiKey);
		params.put("search", search);
		CreHttpRequest.doHttpPost(Global._pserverUrl, params,receiver);
	}

	/**
	 *
	 * responsible for the data storage in the sqlite table
	 * @param products
	 */
	public void setResultFromNetwork(List<Product> products) {
		inventoryDao.setProducts(products);
	}
}

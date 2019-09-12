package com.softvision.test_proj.designing.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> list;
	
	public Cart() {
		list = new ArrayList<>();
	}
	
	public void addItem(Product p) {
		list.add(p);
	}
	
}

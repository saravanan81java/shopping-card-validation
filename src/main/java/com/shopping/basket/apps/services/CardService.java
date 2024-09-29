package com.shopping.basket.apps.services;

import java.util.List;

public interface CardService {

	boolean isValid(String cardNumber);

	void display();

	List<Product> getAllProducts();

	Product getProductById(String productUid);

}

package com.shopping.basket.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.basket.apps.services.CardService;
import com.shopping.basket.apps.services.Product;

@RestController
public class CardRestController {
	
	
	@Autowired
	private CardService cardValidateService;
	
	
	@GetMapping("/card/valid/{card}")
	public boolean isCardValidation(@PathVariable("card") String cardNumber  ) {
		
		return cardValidateService.isValid(cardNumber);
	}
	
	@GetMapping("/getProducts")
	public List<Product> getProducts(){
		return cardValidateService.getAllProducts();
	} 
	
	@GetMapping("/product/id/{card}")
	public Product getProductbyUid(@PathVariable("card") String uid) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cardValidateService.getProductById(uid);
	}

}

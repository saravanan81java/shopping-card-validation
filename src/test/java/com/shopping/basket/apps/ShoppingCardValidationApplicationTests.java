package com.shopping.basket.apps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shopping.basket.apps.services.CardService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShoppingCardValidationApplicationTests {
 
	private static String inValidCard;
	private static String validCard;
	
	
	@Autowired
	private CardService cardValidateService;
	
	
	
	@Autowired
	private CardService cardInValidateService;
	
	
	
     
	
	
	@BeforeAll
	public static void setup() {
		//cardValidateService = new CardValidateService();
		inValidCard = "4388576018402626";
		validCard = "4111111111111111";
		System.out.println(inValidCard);
		System.out.println(validCard);
	}
	
	@Test
	public void isValidCardTest() {
		boolean flag = cardValidateService.isValid(validCard);
		assertTrue(flag);
		cardValidateService.display();
	}
	
	@Test
	public void isInValidCardTest() {
		boolean flag = cardValidateService.isValid(inValidCard);
		assertTrue(!flag);
		
	    
	    cardInValidateService.display();
	}
	
	
	
	
	
	
	

}

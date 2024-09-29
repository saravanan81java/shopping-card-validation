package com.shopping.basket.apps.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CardInValidateService implements CardService{
	
	 
	//4388576018402626
	//4111111111111111
	@Override
	public boolean isValid(String cardNumber)
	{
		
		if(cardNumber == null || cardNumber.isEmpty() ) {
			return false;
		}
		
		if(cardNumber.length() != 16  )
			return false;
		
		boolean x = true;
		int sum=0;
		int temp=0;
		//card number end digit backward move
		// and double every second digit
		for (int i = cardNumber.length()-1; i >= 0; i--) {
			//6
			temp = cardNumber.charAt(i) - '0';
			
			if(x = !x) {
				//
				if(temp > 4) {
					//
					sum += temp * 2 -9;
				}else {
					sum += temp * 2;
				}
			}else {
				sum += temp;
			}
		}
		
		return sum%10 == 0;
	}

	@Override
	public void display() {
		System.out.println("It's CardInValidateService");
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(String productUid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * 
48. 0
49. 1
50. 2
51. 3
52. 4
53. 5
54. 6

55. 7
56. 8
57. 9
	 * */

}

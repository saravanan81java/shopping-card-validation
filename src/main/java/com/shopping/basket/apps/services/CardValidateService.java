package com.shopping.basket.apps.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.shopping.basket.apps.services.Product.UnitPrice;

@Service
public class CardValidateService implements CardService{
	
	private List<Product> listOfProduct = new ArrayList<>(); 
	
	@PostConstruct
	public void init() {
		
		Product prod = new Product();
		prod.setImage("https://assets.sainsburys-groceries.co.uk/gol/6447344/image.jpg");
		prod.setIs_available(true);
		prod.setName("Sainsbury's Skin on ASC Scottish Salmon Fillets x2 240g");
		prod.setProductType("BASIC");
		prod.setProductUid("6447344");
		UnitPrice unitPrice =  prod.getUnit_price();
		unitPrice.setMeasure("kg");
		unitPrice.setMeasure_amount(1);
		unitPrice.setPrice(15.63F);
		prod.setUnit_price(unitPrice);
		
		listOfProduct.add(prod);
		
		
		prod = new Product();
		prod.setImage("https://assets.sainsburys-groceries.co.uk/gol/6447344/image.jpg");
		prod.setIs_available(true);
		prod.setName("Sainsbury's Skin on ASC Scottish Salmon Fillets x5 240g");
		prod.setProductType("ADVANCED");
		prod.setProductUid("3052068");
		UnitPrice unitPrice2 =  prod.getUnit_price();
		unitPrice2.setMeasure("kg");
		unitPrice2.setMeasure_amount(10);
		unitPrice2.setPrice(25.63F);
		prod.setUnit_price(unitPrice2);
		
		
		listOfProduct.add(prod);
		
		
		
		
		/*
		 * 
		 * [{"product_uid":"6447344","product_type":"BASIC","name":"Sainsbury's Skin on ASC Scottish Salmon Fillets x2 240g",
		 * "image":"https://assets.sainsburys-groceries.co.uk/gol/6447344/image.jpg","unit_price":{"price":15.63,"measure":"kg","measure_amount":1},
		 * "is_available":true},{"product_uid":"3052068","product_type":"BASIC","name":"Sainsbury's Skin on ASC Scottish Salmon Fillets x2 240g",
		 * "image":"https://assets.sainsburys-groceries.co.uk/gol/6447344/image.jpg","unit_price":{"price":15.63,"measure":"kg","measure_amount":1},
		 * "is_available":true}]
		 * */
	}
	
	 
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
	
	@Override
	public void display() {
		System.out.println("It's CardValidateService");
	}

	@Override
	public List<Product> getAllProducts(){
		return this.listOfProduct;
	}
	
	@Override
	public Product getProductById(String productUid){
		Product result = null;
		Optional<Product> prod = this.listOfProduct.stream().filter(p -> productUid.equalsIgnoreCase(p.getProductUid())).findFirst();
		if(prod.isPresent()) {
			result = prod.get();
		}
		return result;
	}
	
}

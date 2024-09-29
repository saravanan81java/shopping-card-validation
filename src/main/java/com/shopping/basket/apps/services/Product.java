package com.shopping.basket.apps.services;

public class Product {
	
	public class UnitPrice {
		private float price;
		private String measure;
		private double measure_amount;
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public String getMeasure() {
			return measure;
		}
		public void setMeasure(String measure) {
			this.measure = measure;
		}
		public double getMeasure_amount() {
			return measure_amount;
		}
		public void setMeasure_amount(double measure_amount) {
			this.measure_amount = measure_amount;
		}
		
		 
	}
	
	private String productUid;
	private String productType;
	private String name;
	private String image;
	private Boolean is_available;
	private UnitPrice unit_price;
	public void setProductUid(String productUid) {
		this.productUid = productUid;
	}
	
	public String getProductUid() {
		return productUid;
	}
		
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getIs_available() {
		return is_available;
	}
	public void setIs_available(Boolean is_available) {
		this.is_available = is_available;
	}
	public UnitPrice getUnit_price() {
		if(unit_price == null) {
			 unit_price = new UnitPrice();
		}
		return unit_price;
	}
	public void setUnit_price(UnitPrice unit_price) {
		this.unit_price = unit_price;
	}
	@Override
	public String toString() {
		return "{ \"product_uid\":\"" + this.productUid + "\", \"productType\":\"" + this.productType + "\", \"name\"" + this.name + "\", \"image\""
				+ this.image + "\", \"is_available\"" + this.is_available + ",\"unit_price\":{\"price\":"+this.unit_price.price
				+",\"measure\":\""+this.unit_price.measure+"\",\"measure_amount\":"+this.unit_price.measure_amount+"} }";
	}
	
	
	
	/*
	 * 
	 * [{"product_uid":"6447344","product_type":"BASIC","name":"Sainsbury's Skin on ASC Scottish Salmon Fillets x2 240g",
	 * "image":"https://assets.sainsburys-groceries.co.uk/gol/6447344/image.jpg",
	 * "unit_price":{"price":15.63,"measure":"kg","measure_amount":1},
	 * "is_available":true},{"product_uid":"3052068","product_type":"BASIC","name":"Sainsbury's Skin on ASC Scottish Salmon Fillets x2 240g","image":"https://assets.sainsburys-groceries.co.uk/gol/6447344/image.jpg","unit_price":{"price":15.63,"measure":"kg","measure_amount":1},"is_available":true}]*/

}

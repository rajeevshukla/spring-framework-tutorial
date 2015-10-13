package com.demo;

public class Address  implements Validator {
	
	private String street;
	private String city;
	private String country;
	
	
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", country="
				+ country + "]";
	}
	
	public void init(){
		System.out.println("default adress initilization");
	}
	public void destroy(){
		System.out.println("default address destroy method.");
	}
	
	@Override
	public void validate() {
		System.out.println(" ============ Validating addresss from web service call. ==========");
	}
	
}

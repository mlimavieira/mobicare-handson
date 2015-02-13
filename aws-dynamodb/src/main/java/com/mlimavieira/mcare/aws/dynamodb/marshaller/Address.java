package com.mlimavieira.mcare.aws.dynamodb.marshaller;

public class Address {

	private String street;
	private String neighborhood;
	private String number;
	private String city;
	private String estate;

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(final String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getEstate() {
		return estate;
	}

	public void setEstate(final String estate) {
		this.estate = estate;
	}

}

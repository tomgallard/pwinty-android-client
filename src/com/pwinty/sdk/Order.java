package com.pwinty.sdk;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
	private long id;
	private String recipientName;
	private String address1;
	private String address2;
	private String addressTownOrCity;
	private String stateOrCounty;
	private String postalOrZipCode;
	private String country;
	private String status;
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddressTownOrCity(String addressTownOrCity) {
		this.addressTownOrCity = addressTownOrCity;
	}

	public String getAddressTownOrCity() {
		return addressTownOrCity;
	}

	public void setStateOrCounty(String stateOrCounty) {
		this.stateOrCounty = stateOrCounty;
	}

	public String getStateOrCounty() {
		return stateOrCounty;
	}

	public void setPostalOrZipCode(String postalOrZipCode) {
		this.postalOrZipCode = postalOrZipCode;
	}

	public String getPostalOrZipCode() {
		return postalOrZipCode;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}

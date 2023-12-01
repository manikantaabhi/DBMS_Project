package com.crop.model;

public class Farmer {
	private int farmerId;
	private String firstName;
	private String lastName;
	private Address address;
	private Land land;
	public int getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Land getLand() {
		return land;
	}
	public void setLand(Land land) {
		this.land = land;
	}
}

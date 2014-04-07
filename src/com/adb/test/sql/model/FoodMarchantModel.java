package com.adb.test.sql.model;

public class FoodMarchantModel {
	public int id;
	public String marchant;
	public String owner;
	public String address;
	public String phone;
	
	public int getId() {
		return id;
	}
	public FoodMarchantModel setId(int id) {
		this.id = id;
		return this;
	}
	public String getMarchant() {
		return marchant;
	}
	public FoodMarchantModel setMarchant(String marchant) {
		this.marchant = marchant;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public FoodMarchantModel setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public FoodMarchantModel setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public FoodMarchantModel setOwner(String owner) {
		this.owner = owner;
		return this;
	}
	public String getOwner() {
		return owner;
	}
	
	
}

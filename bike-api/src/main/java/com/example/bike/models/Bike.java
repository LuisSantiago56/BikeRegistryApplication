package com.example.bike.models;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Bike {

	private int Id;
	private boolean Contact;
	private String Email;
	private String Model;
	private String Name;
	private String Phone;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
	private Date purchaseDate;
	private BigDecimal purchasePrice;
	private String serialNumber;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public boolean getContact() {
		return Contact;
	}
	public void setContact(boolean contact) {
		Contact = contact;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	@Override
	public String toString() {
		return "Bike [Id=" + Id + ", Contact=" + Contact + ", Email=" + Email + ", Model=" + Model + ", Name=" + Name
				+ ", Phone=" + Phone + ", purchaseDate=" + purchaseDate + ", purchasePrice=" + purchasePrice
				+ ", serialNumber=" + serialNumber + "]";
	}
	
	
}

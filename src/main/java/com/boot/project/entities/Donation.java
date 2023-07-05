package com.boot.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Donation")
public class Donation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String firstName;
	@Column
	private String secondName;
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	@Column(nullable = false, unique = true)
	private long phone;
	@Column
	private String gender;
	@Column(nullable = false, unique = true)
	private String foodQuality;
	@Column(nullable = false, unique = true)
	private String foodSender;
	@Column(nullable = false, unique = true)
	private String organization;
	@Column
	private String foodInfo;
	@Column(nullable = false, unique = true)
	private String address;
	@Column(nullable = false)
	private int postal;
	
	public Donation() {
		super();
	}
	public Donation(long id, String firstName, String secondName, String email, long phone, String gender,
			String foodQuality, String foodSender, String organization, String foodInfo, String address, int postal) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.foodQuality = foodQuality;
		this.foodSender = foodSender;
		this.organization = organization;
		this.foodInfo = foodInfo;
		this.address = address;
		this.postal = postal;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFoodQuality() {
		return foodQuality;
	}
	public void setFoodQuality(String foodQuality) {
		this.foodQuality = foodQuality;
	}
	public String getFoodSender() {
		return foodSender;
	}
	public void setFoodSender(String foodSender) {
		this.foodSender = foodSender;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getFoodInfo() {
		return foodInfo;
	}
	public void setFoodInfo(String foodInfo) {
		this.foodInfo = foodInfo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPostal() {
		return postal;
	}
	public void setPostal(int postal) {
		this.postal = postal;
	}
	
	
}

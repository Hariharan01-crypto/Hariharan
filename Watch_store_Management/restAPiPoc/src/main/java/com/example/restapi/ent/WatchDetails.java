package com.example.restapi.ent;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Watch_details")
public class WatchDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int wid;
	private String brand;
	private String type;
    private long price;
public WatchDetails() {
	
}

//constructor
public WatchDetails(String brand, String type, long price) {
	super();
	this.brand = brand;
	this.type = type;
	this.price=price;
}
public long getPrice() {
	return price;
}
public void setPrice(long price) {
	this.price = price;
}
public int getWid() {
	return wid;
}
public void setWid(int wid) {
	this.wid = wid;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	return "WatchDetails [wid=" + wid + ", brand=" + brand + ", type=" + type + ", price=" + price + "]";
}

//toString





}



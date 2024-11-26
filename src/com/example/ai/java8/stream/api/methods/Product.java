package com.example.ai.java8.stream.api.methods;

public class Product {
 private String name;
 private long price;
 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getPrice() {
	return price;
}
public void setPrice(long price) {
	this.price = price;
}
public Product(String name, long price) {
	super();
	this.name = name;
	this.price = price;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
 
}

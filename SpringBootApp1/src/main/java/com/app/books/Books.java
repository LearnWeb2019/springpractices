package com.app.books;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books {
	
	@Id
	private String bid;
	private String bname;
	private int price;
	
	public Books() {

	}
	
	public Books(String bid, String bname, int price) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.price = price;
	}
	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "Books [bid=" + bid + ", bname=" + bname + ", price=" + price + "]";
	}
	
	
	
	

}

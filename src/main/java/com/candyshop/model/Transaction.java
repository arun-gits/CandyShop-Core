package com.candyshop.model;

public class Transaction {

	private Integer id;

	private Integer order_id;

	private Integer choco_id;

	private String choco_name;

	private Integer choco_price;

	private Integer choco_quantity;

	private String payment_mode;

	private String purchased_on;

	private String user_address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getChoco_id() {
		return choco_id;
	}

	public void setChoco_id(Integer choco_id) {
		this.choco_id = choco_id;
	}

	public String getChoco_name() {
		return choco_name;
	}

	public void setChoco_name(String choco_name) {
		this.choco_name = choco_name;
	}

	public Integer getChoco_price() {
		return choco_price;
	}

	public void setChoco_price(Integer choco_price) {
		this.choco_price = choco_price;
	}

	public Integer getChoco_quantity() {
		return choco_quantity;
	}

	public void setChoco_quantity(Integer choco_quantity) {
		this.choco_quantity = choco_quantity;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public String getPurchased_on() {
		return purchased_on;
	}

	public void setPurchased_on(String purchased_on) {
		this.purchased_on = purchased_on;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	@Override
	public String toString() {
		return "Shopping [id=" + id + ", order_id=" + order_id + ", choco_id=" + choco_id + ", choco_name=" + choco_name
				+ ", choco_price=" + choco_price + ", choco_quantity=" + choco_quantity + ", payment_mode="
				+ payment_mode + ", purchased_on=" + purchased_on + ", user_address=" + user_address + "]";
	}

}

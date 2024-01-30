package com.example.demo.entry;

public class CustomerEx extends com.example.demo.entity.Customer {

	private String password;
	
	public CustomerEx() {
		super();
	}
	
	public CustomerEx(String name, String address, String tel, String email, String password) {
		super(name, address, tel, email, password);
		this.password = password;
	}

	public CustomerEx(String name, String address, String tel, String email) {
		super(name, address, tel, email);
	}

	public String getPassword() {
		return this.password;
	}
}

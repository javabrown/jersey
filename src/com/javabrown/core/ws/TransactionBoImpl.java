package com.javabrown.core.ws;
 
public class TransactionBoImpl implements TransactionBo {
	public String save(String data) {
		return "Jersey + Spring example "+data;
	}
}
package com.pratiti.exceptions;

public class CustomerServiceException extends RuntimeException{   //if we use this unchecked type then we can skip throw after class name
	
	private int id;
		
	public CustomerServiceException(String msg){
	super(msg);
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
}



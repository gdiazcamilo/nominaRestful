package com.model;

public class Result {

	private boolean result;
	private String errorMessage;
	private String userDescription;
	
	
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userErrorDescription) {
		this.userDescription = userErrorDescription;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return errorMessage;
	}
	public void setMessage(String message) {
		this.errorMessage = message;
	}
	
	
}

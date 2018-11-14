package com.candidates.exception;

public class ExceptionResponse {
	
	private String error_code;
	private String error_message;
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [error_code=" + error_code
				+ ", error_message=" + error_message + "]";
	}
	
	

}

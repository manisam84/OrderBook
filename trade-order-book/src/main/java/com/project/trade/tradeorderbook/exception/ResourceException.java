package com.project.trade.tradeorderbook.exception;

import org.springframework.http.HttpStatus;

public class ResourceException extends RuntimeException {

	public HttpStatus httpstatus = HttpStatus.BAD_GATEWAY;
	public ResourceException(HttpStatus httpStatus,String message)
	{
		super(message);
		this.httpstatus = httpStatus;
	}
	
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}
}

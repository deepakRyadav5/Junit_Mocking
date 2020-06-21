package com.dpk.poc.mockito.exceptons;

public class NoRecordFoundException extends RuntimeException {

	public NoRecordFoundException() {
	}

	public NoRecordFoundException(String msg) {
		super(msg);
	}
}

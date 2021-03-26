package com.pratice.eurekaclient.Entity;

import lombok.Data;

@Data
public class ResponseBodyEntity<T> {
	/**
	 * 響應狀態
	 */
	private String state;
	private String message;
	private T result;
}

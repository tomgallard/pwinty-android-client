package com.pwinty.sdk.ResponseListeners;

import org.springframework.http.HttpStatus;

import com.pwinty.sdk.Order;

public interface GetOrdersListener extends ResponseListener{
	void onComplete(Order[] orders, HttpStatus status);
}

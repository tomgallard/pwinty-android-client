package com.pwinty.sdk;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pwinty.sdk.ResponseListeners.GetOrdersListener;

import android.os.Handler;

public class Client {
	private URL _sandboxUrl; 
	private boolean _isTest = true;
	private URL _liveUrl; 
	private String _apiKey;
	private String _merchantId;
	/**
     * Handler through which response listener callbacks will be invoked.
     */
    private final Handler mHandler;
	private URL getBaseURL()
	{
		if(_isTest) {
			return _sandboxUrl;
		}
		return _liveUrl;
	}
	
	public Client(boolean isTest,String apiKey,String merchantId) throws MalformedURLException
	{
		_sandboxUrl = new URL("https://sandbox.pwinty.com");
		_liveUrl = new URL("https://live.pwinty.com");
		_apiKey = apiKey;
		_merchantId = merchantId;
		_isTest = isTest;
		mHandler = new Handler();
	}

	public final void getOrders(final GetOrdersListener listener) throws MalformedURLException {
		final URL mergedURL = new URL(getBaseURL(),"/Orders" );
		
        new Thread() {

            @Override
            public void run() {
                try {
                	final ResponseEntity<Order[]> result = getResponse(mergedURL.toString(),HttpMethod.GET,Order[].class );
                    mHandler.post(new Runnable() {

                        @Override
                        public void run() {
                            listener.onComplete(result.getBody(), result.getStatusCode());
                        }
                    });
                }
                catch (final Exception e) {
                    mHandler.post(new Runnable() {

                        @Override
                        public void run() {
                            listener.onException(e);
                        }
                    });
                }
            }
        }.start();
    }
	private <T> ResponseEntity<T> getResponse(String url,HttpMethod method,Class<T> type)
	{
		RestTemplate template = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("X-Pwinty-MerchantId", _merchantId);
		requestHeaders.add("X-Pwinty-REST-API-Key", _apiKey);
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		return template.exchange(url, method, requestEntity, type);
	}
}

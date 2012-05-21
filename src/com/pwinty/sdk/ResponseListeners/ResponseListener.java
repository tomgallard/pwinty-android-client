package com.pwinty.sdk.ResponseListeners;

import java.io.IOException;

public interface ResponseListener {

    /** Unknown HTTP response code. */
    String STATUS_UNKNOWN_HTTP_RESPONSE_CODE = "unknown_http_response_code";
    /** Invalid API key, or the API key is restricted from calling the API action. */
    String STATUS_APPLICATION_RESTRICTED = "application_restricted";


	void onException(Exception e);
}

package com.medical_app.bc_backend.Utils;

import org.springframework.http.HttpHeaders;

public class JSONUtils {
	public static HttpHeaders getHttpHeaders( ) {
		HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
	    return headers;
	}
}

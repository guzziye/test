package com.css.eshop.ws.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

//import javax.servlet.http.Cookie;

public abstract class AbstractRestWeService {

	public static final String BASE_URI = "http://192.168.1.101:8080/jerseywstest/rest/";

	protected static final String HEADER_AUTH_KEY = "Authorization";
	protected static final String HEADER_AUTH_VALUE_BASIC_ADMIN = "Basic YWRtaW46bmltZGE=";
	protected static final String HEADER_CONTENT_TYPE = "Content-Type";

	protected static javax.ws.rs.core.Cookie tenantCookie;
	private static String auth;

	protected WebResource configWebResource() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(BASE_URI);
		return webResource;
	}
}

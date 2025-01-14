package com.resourcePOC;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utilis {

	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {

		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return req;
		}
		return req;

	}

	public static String getGlobalValue(String key) throws IOException {

		Properties p = new Properties();

		FileInputStream fis = new FileInputStream(
				"C://Users//fselvakumar//New Eclipse 2024//BookingFramework//src//test//java//com//resource//global.properties");

		p.load(fis);

		return p.getProperty(key);

	}

	public String getJsonPath(Response response, String key) {

		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

}

package com.test_GoogleMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoogleMapTest_TC003 {

	@Test
	public void GoogleAPITest() {
		RestAssured.baseURI = "https://maps.googleapis.com";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// attach above data to the request

		// Response object
		Response response = httpRequest.request(Method.POST,
				"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		// print response in console window

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		// verify the head path and what api will get created and capture header
		// deatils

		String CT = response.header("Content-Type");
		Assert.assertEquals(CT, "application/xml; charset=UTF-8");

		String contentEncoding = response.header("Content-Encoding");// capture
																		// details
																		// of
																		// Content-Encoding
																		// header
		System.out.println("Content Encoding is:" + contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");

	}

}

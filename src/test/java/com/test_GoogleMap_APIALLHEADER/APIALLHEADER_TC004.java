package com.test_GoogleMap_APIALLHEADER;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIALLHEADER_TC004 {

	@Test
	public void GOOGLEALLHEADER() {
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

		// to get All the header and header values
		Headers allHeader = response.headers();

		for (Header Header : allHeader) {
			System.out.println("The Header Name:" + Header.getName() + "THe Header value is:" + Header.getValue());

		}

	}

}

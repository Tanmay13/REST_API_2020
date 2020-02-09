package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_TC001{
	@Test
	public void Getweathedetails() {
		// Specifice Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		// Represting the request object
		RequestSpecification httprequest = RestAssured.given();
		// Responceobject
		Response rp = httprequest.request(Method.GET, "/Ambada");
		
	//rint responce in console windows
		
		String Responcebody=rp.getBody().asString();
		System.out.println("Responce body is:"+Responcebody);
		
		//Status code validation is start
		int Statuscode=rp.getStatusCode();
		System.out.println("the Status code is:"+Statuscode);
		Assert.assertEquals(Statuscode, 200);
		
		//Status line verification
		String StatusLine=rp.getStatusLine();
		System.out.println("The Status Line is:"+StatusLine);
		
	

	}

}

package com.Api.GitHub.BaseApiLayer;

import java.io.FileOutputStream;
import java.io.PrintStream;

import com.Api.GitHub.Helper.ReadProperties;
import com.Api.GitHub.UtilityLayer.UtilsClass;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

	public ReadProperties prop = new ReadProperties();
	public UtilsClass util =new UtilsClass();
	public RequestSpecification httpReq;
	
	String path = System.getProperty("user.dir")+"\\com.Api.GitHub.LogsFolder\\logs"+util.getCurrentDateAndTime()+".txt";

	public RequestSpecification getRequestSpecification() throws Exception 
	{
		if(httpReq==null)
		{
			
		FileOutputStream fio = new FileOutputStream(path);

		PrintStream log = new PrintStream(fio);

		httpReq= RestAssured
				.given()
				.baseUri(prop.getProperty("baseUri"))
				.header("Authorization", "Bearer " + prop.getProperty("accessToken"))
				.log().all()
				.filter(RequestLoggingFilter.logRequestTo(log))
				.filter(ResponseLoggingFilter.logResponseTo(log));
		}
		
		return httpReq;
	}

}

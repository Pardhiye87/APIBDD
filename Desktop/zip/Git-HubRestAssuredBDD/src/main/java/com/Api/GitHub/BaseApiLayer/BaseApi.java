package com.Api.GitHub.BaseApiLayer;

import java.io.FileNotFoundException;
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
	public FileOutputStream fio;
	public PrintStream log;
	
	String path = System.getProperty("user.dir")+"\\com.Api.GitHub.LogsFolder\\logs_"+util.getCurrentDateAndTime()+".txt";

	public RequestSpecification getRequestSpecification()
	{
		if(httpReq==null)
		{
			
		
		try 
		{
			fio = new FileOutputStream(path);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		log = new PrintStream(fio);

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

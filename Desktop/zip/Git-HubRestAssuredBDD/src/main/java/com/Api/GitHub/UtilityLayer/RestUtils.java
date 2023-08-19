package com.Api.GitHub.UtilityLayer;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {
	
	public Response createRepository(RequestSpecification httpReq)
	{
		return httpReq.when().post();
	}
	
	
	public Response getRepositoryAsPerRepoName(RequestSpecification httpReq,String repoName)
	{
		return httpReq.when().get(repoName);
	}
	
	public Response updateRepositoryAsPerRepoName(RequestSpecification httpReq,String repoName)
	{
		return httpReq.when().patch(repoName);
	}
	
	public Response deleteRepositoryAsPerRepoName(RequestSpecification httpReq,String repoName)
	{
		return httpReq.when().delete(repoName);
	}

}

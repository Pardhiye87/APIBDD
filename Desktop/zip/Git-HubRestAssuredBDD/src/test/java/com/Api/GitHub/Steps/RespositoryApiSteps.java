package com.Api.GitHub.Steps;

import java.io.File;

import org.hamcrest.Matchers;

import com.Api.GitHub.BaseApiLayer.BaseApi;
import com.Api.GitHub.Helper.ReadJsonFile;
import com.Api.GitHub.UtilityLayer.RestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import junit.framework.Assert;

public class RespositoryApiSteps extends BaseApi {

	private BaseApi base;
	private Response resp;
	private static RestUtils rest;
	private static ReadJsonFile json;
	private static String repositoryName;

	@Given("get the request Specification object and pass the base path as {string}")
	public void get_the_request_specification_object_and_pass_the_base_path_as(String basePath) throws Exception {
		base = new BaseApi();
		httpReq = base.getRequestSpecification().basePath(basePath);

	}

	@Given("add content type header and request payload from json file and pass the json node name as {string}")
	public void add_content_type_header_and_request_payload_from_json_file_and_pass_the_json_node_name_as(
			String jsonNodeName) throws Exception {

		json = new ReadJsonFile();
		String reqbody = json.requestBody(jsonNodeName);
		httpReq = httpReq.contentType(ContentType.JSON).body(reqbody);
	}

	@When("user select HTTP POST request")
	public void user_select_http_post_request() {

		rest = new RestUtils();
		resp = rest.createRepository(httpReq);

	}

	@Then("validate status code as {int}")
	public void validate_status_code_as(Integer code) {
		resp.then().log().all().assertThat().statusCode(code);
	}

	@Then("validate status line as {string}")
	public void validate_status_line_as(String line) {
		resp.then().assertThat().statusLine(line);
	}

	@Then("validate response Header {string}")
	public void validate_response_header(String expectedHeader) {
		String actualheader = resp.getHeader("Content-Type");
		Assert.assertEquals(actualheader, expectedHeader);

	}

	@Then("capture repository name from response payload")
	public void capture_repository_name_from_response_payload() {
		repositoryName = resp.jsonPath().getString("name");
	}

	@Then("validate Response body Repository name as {string} and desciption as {string} and home page as {string}")
	public void validate_response_body_repository_name_as_and_desciption_as_and_home_page_as(String reponame,
			String desc, String homepage) {

		resp.then().assertThat().body("name", Matchers.equalTo(reponame)).body("description", Matchers.equalTo(desc))
				.body("homepage", Matchers.equalTo(homepage));
	}

	@Then("validate Json schema for Repository")
	public void validate_json_schema_for_repository() {

		String path = "C:\\Users\\Admin\\Desktop\\zip\\Git-HubRestAssuredBDD\\com.Api.GitHub.Resources\\RepositorySchema.json";

		resp.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(path)));

	}

}

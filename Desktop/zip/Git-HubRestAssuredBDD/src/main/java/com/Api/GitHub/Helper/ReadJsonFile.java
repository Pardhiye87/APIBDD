package com.Api.GitHub.Helper;

import java.io.FileReader;

import com.Api.GitHub.Model.RepositoryPojo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJsonFile {

	String path = System.getProperty("user.dir") + "\\com.Api.GitHub.Resources\\TestData\\Repository.json";
	FileReader file;

	public String requestBody(String nodeName) throws Exception {

		file = new FileReader(path);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode json = mapper.readTree(file);

		RepositoryPojo repos = mapper.treeToValue(json.get(nodeName), RepositoryPojo.class);

		String reqbody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(repos);

		return reqbody;
	}

}

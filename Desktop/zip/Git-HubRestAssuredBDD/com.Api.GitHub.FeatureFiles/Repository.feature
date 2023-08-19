Feature: Test End to End flow of Git Hub Repository

  Scenario: Validate Created Repository by using HTTP Post Request
    Given get the request Specification object and pass the base path as "/user/repos"
    And add content type header and request payload from json file and pass the json node name as "createRepository"
    When user select HTTP POST request
    Then validate status code as 201
    And validate status line as "HTTP/1.1 201 Created"
    And capture repository name from response payload
    And validate response Header "application/json; charset=utf-8"
    And validate Response body Repository name as "Orange" and desciption as "Repository Created" and home page as "https://github.com"
    And validate Json schema for Repository

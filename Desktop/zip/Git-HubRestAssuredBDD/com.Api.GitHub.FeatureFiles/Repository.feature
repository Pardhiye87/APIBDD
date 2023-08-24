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

     Scenario: Validate Created Repository by using HTTP Get Request
    Given get the request Specification object and pass the base path as "/repos/Pardhiye87"
    When user select HTTP GET request
    Then validate status code as 200
    And validate status line as "HTTP/1.1 200 OK"
    And validate response Header "application/json; charset=utf-8"
    And validate Response body Repository name as "Orange" and desciption as "Repository Created" and home page as "https://github.com"
    And validate Json schema for GET Repository
    
    #Scenario: Validate Created Repository by using HTTP Patch Request
    #Given get the request Specification object and pass the base path as "/repos/Pardhiye87"
    #And add content type header and request payload from json file and pass the json node name as "updateRepository"
    #When user select HTTP PATCH request
    #Then validate status code as 200
    #And validate status line as "HTTP/1.1 200 OK"
    #And validate response Header "application/json; charset=utf-8"
    #And validate Response body Repository name as "punepune" and desciption as "Repository Created" and home page as "https://github.com"
    
    Scenario: Validate Created Repository by using HTTP Delete Request
    Given get the request Specification object and pass the base path as "repos/Pardhiye87"
    When user select HTTP DELETE request
    Then validate status code as 204
    And validate status line as "HTTP/1.1 204 No Content"
 
  Scenario: Validate Created Repository by using HTTP Get Request
    Given get the request Specification object and pass the base path as "/repos/Pardhiye87"
    When user select HTTP GET request
    Then validate status code as 404
    And validate status line as "HTTP/1.1 404 Not Found"
    
    
    
    
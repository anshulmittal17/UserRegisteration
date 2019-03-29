package com.Trex.DeckDesiner.Automation.API;

import static io.restassured.RestAssured.*;

import com.Trex.DeckDesiner.Automation.POJO.UserLogin;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserLoginAPI extends TestSetup{
	
	public static Response sendPostRequestToLoginAPI(UserLogin userLoginData,String endpoint)
	{
		Response response=requestSpecification.body(userLoginData).post(endpoint);
		return response;
	}
	
	
	
	

}

package com.Trex.DeckDesiner.Automation.API;

import com.Trex.DeckDesiner.Automation.POJO.UserLogin;
import com.Trex.DeckDesiner.Automation.POJO.UserRegisteration;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;

import io.restassured.response.Response;

public class UserRegisterationAPI extends TestSetup{
	public static Response sendPostRequestToRegisterationAPI(UserRegisteration userRegisterationData,String endpoint)
	{
		Response response=requestSpecification.body(userRegisterationData).post(endpoint);
		return response;
	}
}

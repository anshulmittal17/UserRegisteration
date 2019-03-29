package com.Trex.DeckDesiner.Automation.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Trex.DeckDesiner.Automation.API.UserLoginAPI;
import com.Trex.DeckDesiner.Automation.POJO.UserLogin;
import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import io.restassured.response.Response;
import static com.Trex.DeckDesiner.Automation.Utils.Json.*;

import java.net.URISyntaxException;

public class ValidateUserLoginAPI extends TestSetup {

	@Test(enabled=true,priority=0)
	public void validateLoginWithValidDetails() throws URISyntaxException {
		UserLogin loginData = new UserLogin("abhigya.jha@gmail.com", "tester");

		Response response = UserLoginAPI.sendPostRequestToLoginAPI(loginData, configProperty.getUserLoginAPIEndPoint());

		AssertJUnit.assertEquals(response.statusCode(), 200);

		AssertJUnit.assertEquals(response.statusLine().contains("OK"), true);
		
		AssertJUnit.assertTrue(jsonHasKey(response, "access_token"));

	}
	
	

	@Test(enabled=true,priority=1)
	public void validateLoginWithInValidEmail() throws URISyntaxException {
		UserLogin loginData = new UserLogin("abhigya.jha@gmail", "tester");

		Response response = UserLoginAPI.sendPostRequestToLoginAPI(loginData, configProperty.getUserLoginAPIEndPoint());

		AssertJUnit.assertEquals(response.statusCode(), 400);

		AssertJUnit.assertEquals(response.statusLine().contains("Bad Request"), true);
		
		AssertJUnit.assertFalse(jsonHasKey(response, "access_token"));
		
		String actualErrorMessage=response.jsonPath().get("message");
		
		AssertJUnit.assertEquals(actualErrorMessage, "Invalid email address");

	}



}

package com.Trex.DeckDesiner.Automation.Utils;

import org.json.JSONObject;

import io.restassured.response.Response;

public class Json {
	
	public static boolean jsonHasKey(Response responseJson,String key)
	{
		JSONObject json= new JSONObject(responseJson.asString());
		return json.has(key);
	}


}

package MobiquityAPIs;

import org.testng.Assert;
import org.testng.annotations.Test;

import POJO.PostsAPIPojo;
import TestBase.BaseTest;
import apiConfig.APIPath;
import apiConfig.HeaderConfigs;
import apiVerification.APIVerification;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostCreateTest extends BaseTest{
	
	String Title = "Test API Title";
	String Body = "Test API Body";
	String userId = "1";


	@Test
	public void CreatePostAPI() {
		HeaderConfigs header = new HeaderConfigs();
		PostsAPIPojo poj = new PostsAPIPojo(Title , Body, userId);
		Response response = RestAssured.given()
				.headers(header.defaultHeaders())
				.body(poj)
				.when().post(APIPath.POST_POSTS);
		
		APIVerification.responseCodeValiddation(response, 201);

		
		JsonPath js = new JsonPath(response.getBody().asString());
		
		Assert.assertTrue(js.getString("title").equals(Title));
		Assert.assertTrue(js.getString("body").equals(Body));
		Assert.assertTrue(js.getString("userId").equals(userId));

		
	}
}

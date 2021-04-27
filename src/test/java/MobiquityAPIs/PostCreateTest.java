package MobiquityAPIs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import POJO.PostsAPIPojo;
import TestBase.BaseTest;
import apiConfig.APIPath;
import apiConfig.HeaderConfigs;
import apiVerification.APIVerification;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.JavaUtilities;

public class PostCreateTest extends BaseTest{

	String Title = "Test API Title";
	String Body = "Test API Body";
	String userId = "1";


	@Test(description = "Create a new post for a user and make sure the reponse is correct with the added info")
	public void CreateNewPostAPITest() {
		HeaderConfigs header = new HeaderConfigs();
		test.log(LogStatus.INFO,"createPostTest started..." );

		PostsAPIPojo poj = new PostsAPIPojo(Title , Body, userId);
		Response response = RestAssured.given()
				.headers(header.defaultHeaders())
				.body(poj)
				.when().post(APIPath.POST_POSTS);

		test.log(LogStatus.INFO,"validate the title response code..." );
		APIVerification.responseCodeValiddation(response, 201);

		JsonPath js = JavaUtilities.convertToJson(response.getBody().asString());

		
		test.log(LogStatus.INFO,"validate the title contents..." );
		Assert.assertTrue(js.getString("title").equals(Title));
		
		test.log(LogStatus.INFO,"validate the body contents..." );
		Assert.assertTrue(js.getString("body").equals(Body));
		
		
		test.log(LogStatus.INFO,"validate the userId contents..." );
		Assert.assertTrue(js.getString("userId").equals(userId));

		test.log(LogStatus.INFO,"createPostTest ended..." );



	}
}

package MobiquityAPIs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import POJO.EditAPIPojo;
import TestBase.BaseTest;
import apiConfig.APIPath;
import apiConfig.HeaderConfigs;
import apiVerification.APIVerification;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.JavaUtilities;

public class PutPostsAPITest extends BaseTest {

	String Title = "Adjusted Title";
	String Body = "Adjusted Body";
	String userId = "1";
	String id = "1";


	@Test(description = "Edit an exisiting post with a new post then make sure post is update")
	public void EditExisitingPostAPITest() {
		HeaderConfigs header = new HeaderConfigs();
		test.log(LogStatus.INFO,"EditPostsTest started..." );

		EditAPIPojo putpojo = new EditAPIPojo(Title, Body, userId, id);

		Response resp = RestAssured.given()
				.headers(header.defaultHeaders()).body(putpojo)
				.when().put(APIPath.PUT_EXIST_POSTS);

		test.log(LogStatus.INFO,"validate the response code..." );
		APIVerification.responseCodeValiddation(resp, 200);

		JsonPath jpath = JavaUtilities.convertToJson(resp.getBody().asString());

		test.log(LogStatus.INFO,"validate the title response body..." );
		Assert.assertEquals(Title, jpath.getString("title"));

		test.log(LogStatus.INFO,"validate the body response body..." );
		Assert.assertEquals(Body, jpath.getString("body"));

		test.log(LogStatus.INFO,"validate the userId response body..." );
		Assert.assertEquals(userId, jpath.getString("userId"));

		test.log(LogStatus.INFO,"validate the id response body..." );
		Assert.assertEquals(id, jpath.getString("id"));


		Response getPostDetails = RestAssured.given()
				.headers(header.defaultHeaders()).when().get(APIPath.PUT_EXIST_POSTS);

		test.log(LogStatus.INFO,"validate the response code of getting post API..." );
		APIVerification.responseCodeValiddation(getPostDetails, 200);

		JsonPath jspath = JavaUtilities.convertToJson(getPostDetails.getBody().asString());

		test.log(LogStatus.INFO,"validate the adjusted title of getting post API..." );
		Assert.assertEquals(Title, jspath.getString("title"));

		test.log(LogStatus.INFO,"validate the adjusted body of getting post API..." );
		Assert.assertEquals(Body, jspath.getString("body"));

		test.log(LogStatus.INFO,"EditPostsTest ended..." );

	}


}

package MobiquityAPIs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiConfig.APIPath;
import apiConfig.QueryParams;
import apiVerification.APIVerification;
import TestBase.BaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAPITest extends BaseTest {

	QueryParams param = new QueryParams();

	@Test(priority = 1)
	public void getAPITest() {

		Response resp = 
				RestAssured.given()
				.when().get(APIPath.GET_DATA_FOR_USERS);


		test.log(LogStatus.INFO, "Status code is .." +resp.getStatusCode());
		Assert.assertEquals(200, resp.getStatusCode());

		JsonPath js = new JsonPath(resp.getBody().asString());
		int No_users = js.getInt("size()");
		
		for (int i = 0; i < No_users; i++) {
			if (js.getString("["+i+"].username").equalsIgnoreCase("Delphine")) {
				System.out.println("Name exists!");
				
			}
			
		}


	}


}

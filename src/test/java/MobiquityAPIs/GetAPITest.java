package MobiquityAPIs;

import java.util.ArrayList;
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
import utils.JavaUtilities;

public class GetAPITest extends BaseTest {

	QueryParams param = new QueryParams();
	ArrayList<Integer> postsId = new ArrayList<Integer>();
	String email;

	int User_id;
	@Test(priority = 1)
	public void getAPITest() {

		test.log(LogStatus.INFO,"getAPITest started..." );

		Response resp = 
				RestAssured.given()
				.when().get(APIPath.GET_DATA_FOR_USERS);


		test.log(LogStatus.INFO, "Status code is .." +resp.getStatusCode());
		APIVerification.responseCodeValiddation(resp, 200);
		JsonPath js = new JsonPath(resp.getBody().asString());
		int No_users = js.getInt("size()");

		for (int i = 0; i < No_users; i++) {
			if (js.getString("["+i+"].username").equalsIgnoreCase("Delphine")) {
				User_id = js.getInt("["+i+"].id");
				System.out.println(User_id);
			}	
		}
		test.log(LogStatus.INFO,"getAPITest ended..." );

	}

	@Test(priority = 2)
	public void getPosts() {

		test.log(LogStatus.INFO,"getPostsTest started..." );

		Response response = 
				RestAssured.given()
				.queryParams(param.defaultqueryParams(User_id)).when().get(APIPath.GET_POSTS);
		test.log(LogStatus.INFO, "Status code is .." +response.getStatusCode());
		test.log(LogStatus.INFO,"validate the respone code..." );

		APIVerification.responseCodeValiddation(response, 200);

		JsonPath json = new JsonPath(response.getBody().asString());
		System.out.println(response.getBody().prettyPrint());

		int no_posts =  json.getInt("size()");
		for (int j = 0; j < no_posts;j++) {
			int postNo = json.getInt("["+j+"].id");
			postsId.add(postNo);

		}
		test.log(LogStatus.INFO,"print the designated posts for that user..." );
		System.out.println(postsId);

		test.log(LogStatus.INFO,"Loop over every post and check the comments of it and verify the email" );

		for (int i = 0; i < postsId.size(); i++) {
			System.out.println(postsId.get(i));
			Response rep = RestAssured.given()
					.queryParams(param.queryParamsPostID(postsId.get(i)))
					.when().get(APIPath.GET_COMMENTS);
			APIVerification.responseCodeValiddation(rep, 200);

			JsonPath jp = new JsonPath(rep.getBody().asString());

			test.log(LogStatus.INFO,"Loop over comments in the post" );

			int no_comments = jp.getInt("size()");
			for (int j = 0; j < no_comments; j++) {
				email = jp.getString("["+j+"].email");
				test.log(LogStatus.INFO,"validate the email in every comment" );
				Assert.assertTrue(JavaUtilities.EmailisValid(email));
			}

		}
		test.log(LogStatus.INFO,"getPostsTest ended..." );

	}

}

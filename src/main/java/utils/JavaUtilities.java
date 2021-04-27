package utils;
import org.apache.commons.validator.routines.EmailValidator;

import io.restassured.path.json.JsonPath;

public class JavaUtilities {


	public static boolean EmailisValid(String emailAddress) {
		// create the EmailValidator instance
		EmailValidator validate = EmailValidator.getInstance();

		// check for valid email addresses using isValid method
		return validate.isValid(emailAddress);
	}


	public static JsonPath convertToJson(String response) {
		
		JsonPath js = new JsonPath(response);
		
		return js;
	}

}

package stepdefinition;

import java.io.File;

import org.junit.Assert;

import commonLib.ObjectDeclaration;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;

public class StepDefinition extends ObjectDeclaration {

	public static String response;

	String id = null;

	private final String url = "https://reqres.in/api/users";

	@Given("^I get API users$")
	public void getUsers() {
		response = commonLib.getGetResponse(url, 200);
	}

	@Then("^I validate user$")
	public void verifyUsers() {

		JsonPath js = commonLib.parseJson(response);
		String name = js.getJsonObject("data[0].first_name");
		Assert.assertEquals("George", name);
	}

	@Given("^I hit user creation request using <\"([^\"]*)\">$")
	public void createUser(String fileName) {
		response = commonLib.getPostResponse(new File(commonLib.getAbsoluteFilePath(fileName)), url, 201);
	}

	@Then("^I capture user ID$")
	public void validateUserId() {
		JsonPath js = commonLib.parseJson(response);
		id = js.getJsonObject("id");
		System.out.println("id: " + id);
	}

	@Then("^I delete the created user$")
	public void deleteUser() {
		String deleteURL = url + "/" + id;
		commonLib.doDeleteOperation(deleteURL, 204);
	}

	@Given("^I update user using <\"([^\"]*)\">$")
	public void updateUser(String fileName) {
		String updateURL = url + "/" + id;
		response = commonLib.getPutResponse(new File(commonLib.getAbsoluteFilePath(fileName)), updateURL, 200);
		System.out.println(response);
	}

	@Then("^I validate details as updated$")
	public void validateUpdatedJob() {

		Assert.assertTrue(response.contains("updated"));
	}

}

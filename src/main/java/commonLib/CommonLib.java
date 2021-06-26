package commonLib;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.junit.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonLib extends ObjectDeclaration {

	Response response;

	public String getPostResponse(File payload, String url, Integer status) {

		response = given().body(payload).when().post(url);
		assertStatusCode(response.getStatusCode(), status);
		return response.asString();
	}

	public String getPutResponse(File payload, String url, Integer status) {

		response = given().body(payload).when().put(url);
		assertStatusCode(response.getStatusCode(), status);
		return response.asString();
	}

	public String getGetResponse(String url, Integer status) {
		response = given().get(url);
		assertStatusCode(response.getStatusCode(), status);
		return response.asString();
	}

	public void doDeleteOperation(String url, Integer status) {
		response = given().when().delete(url);
		assertStatusCode(response.getStatusCode(), status);

	}

	public void assertStatusCode(Integer actual, Integer expected) {

		Assert.assertEquals("Actual status code not equal to expected status code", actual, expected);
	}

	public JsonPath parseJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;

	}

	public String getAbsoluteFilePath(String fileName) {

		File file = new File("testdata\\" + fileName);

		String path = file.getAbsolutePath();
		return path;
	}

}
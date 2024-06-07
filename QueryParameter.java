package RestAssuredPrograms;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParameter {
	@Test
	public void queryParam() {
		RestAssured.baseURI="https://bookstore.toolsqa.com/BookStore/v1";
		RequestSpecification httprequest=RestAssured.given();
		Response res=httprequest.queryParam("ISBN","9781449331818").get("/Book");
		ResponseBody body=res.getBody();
		String rbdy=body.asString();
		JsonPath jpath=new JsonPath(rbdy);
		String title=jpath.getString("title");
		System.out.println("The book title is-"+title);
		String author=jpath.getString("author");
		System.out.println("The book author is-"+author);
		
	}

}

package com.stepDefPOC;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import com.resourcePOC.Payload;
import com.resourcePOC.Utilis;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinitionPOC extends Utilis {

	ResponseSpecification resspec;
	Response response;
	RequestSpecification req;
	static String bookingId;

	@Given("Book a hotel with {string},{string}, {int},true,{string},{string},{string}")
	public void book_a_hotel_with_true(String firstname, String lastname, Integer totalprice, String checkin,
			String checkout, String additionalneeds) throws IOException {

		response = given()
				.spec(requestSpecification()).body(Payload.bookHotelPayload(firstname, lastname, totalprice, true,
						checkin, checkout, additionalneeds))
				.when().post().then().assertThat().statusCode(200).extract().response();

		bookingId = getJsonPath(response, "bookingid");
		System.out.println("Booking ID created: " + bookingId);

	}

	@When("the user calls the {string} API")
	public void the_user_calls_the_api(String apiType) throws IOException {

		if (apiType.equalsIgnoreCase("GET")) {

			given().spec(requestSpecification()).pathParam("key", bookingId).when().get("/{key}").then().assertThat()
					.statusCode(200);

		} else if (apiType.equalsIgnoreCase("DELETE")) {

			given().spec(requestSpecification()).pathParam("key", bookingId)
					.header("authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").when().delete("/{key}").then()
					.assertThat().statusCode(201);

		}

	}

	@Then("the API call is successful with status code {int}")
	public void the_api_call_is_successful_with_status_code(Integer statusCode) {

		System.out.println("API call was successful with status code: " + statusCode);

	}

	@Given("a booking exists with the {int}")
	public void a_booking_exists_with_the(Integer existingBookingId) throws IOException {

		given().spec(requestSpecification()).pathParam("key", bookingId).when().get("/{key}").then().assertThat()
				.statusCode(200);

	}

	@Given("user update the booking details with {int},{string},{string}")
	public void user_update_the_booking_details_with(Integer totalprice, String checkin, String checkout)
			throws IOException {

		given().spec(requestSpecification()).pathParam("key", bookingId)
				.header("authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.body(Payload.updatePayload(totalprice, checkin, checkout)).when().put("/{key}").then().assertThat()
				.statusCode(200).extract().response().asString();
	}
}

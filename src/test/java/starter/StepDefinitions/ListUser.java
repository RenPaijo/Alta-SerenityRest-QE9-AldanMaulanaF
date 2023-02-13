package starter.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqresAPI.GetAPI;
import starter.reqresAPI.utilities.JsonSchema;
import starter.reqresAPI.utilities.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ListUser {
    @Steps
    GetAPI getAPI;

//    Valid list user
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        getAPI.getListUser(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(GetAPI.GET_LIST_USER);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File jsonSchemaListUser = new File(JsonSchema.LIST_USER);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

//    Invalid list user
    @Given("Get list user with valid parameter page {string}")
    public void getListUserWithValidParameterPage(String page) {
        getAPI.getListInvalidUser(page);
    }

    @And("Response body page should be {string}")
    public void responseBodyPageShouldBe(String page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }
}

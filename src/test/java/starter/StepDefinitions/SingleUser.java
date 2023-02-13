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

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class SingleUser {
    @Steps
    GetAPI getAPI;

//    Valid single user
    @Given("Get single user with valid parameter {int}")
    public void getSingleUserWithValidParameterId(int id) {
        getAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(GetAPI.SINGLE_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBeId(int id) {
        SerenityRest.then().body("data.id", equalTo(id));
    }

    @And("Validate single user json schema")
    public void validateSingleUserJsonSchema() {
        File singleUser = new File(JsonSchema.SINGLE_USER_SCHEMA);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(singleUser));
    }

//    Invalid single user
    @Given("Get single user with valid parameter {string}")
    public void getSingleUserWithValidParameter(String id) {
        getAPI.getSingleInvalidUser(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}

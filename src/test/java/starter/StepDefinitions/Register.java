package starter.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqresAPI.PostAPI;
import starter.reqresAPI.utilities.JsonSchema;
import starter.reqresAPI.utilities.ReqresResponses;
import starter.reqresAPI.utilities.ReqBody;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class Register {
    @Steps
    PostAPI postAPI;

//    Valid register
    @Given("Create new register with valid json")
    public void createNewRegisterWithValidJson() {
        File jsonReq = new File(ReqBody.REGISTER_REQ);
        postAPI.register(jsonReq);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(PostAPI.REGISTER);
    }

    @And("Response body should be {int} as id and {string} as token")
    public void responseBodyShouldBeAsIdAndAsToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID, equalTo(id))
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate register json schema")
    public void validateRegisterJsonSchema() {
        File register = new File(JsonSchema.REGISTER_SCHEMA);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(register));
    }

//    Invalid register
    @Given("Create new register with invalid json")
    public void createNewRegisterWithInvalidJson() {
        File jsonReq = new File(ReqBody.INVALID_REGISTER_REQ);
        postAPI.register(jsonReq);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body should be {string} as error message")
    public void responseBodyShouldBeAsErrorMessage(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(error));
    }

    @And("Validate unsuccessful register schema")
    public void validateUnsuccessfulRegisterSchema() {
        File invalidRegister = new File(JsonSchema.Invalid_REGISTER_SCHEMA);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(invalidRegister));
    }
}

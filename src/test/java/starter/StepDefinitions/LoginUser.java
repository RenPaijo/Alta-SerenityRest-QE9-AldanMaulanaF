package starter.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqresAPI.PostAPI;
import starter.reqresAPI.utilities.JsonSchema;
import starter.reqresAPI.utilities.ReqBody;
import starter.reqresAPI.utilities.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginUser {
    @Steps
    PostAPI postAPI;

//    Valid login user
    @Given("Login with existing user with valid json")
    public void loginWithExistingUserWithValidJson() {
        File jsonReq = new File(ReqBody.LOGIN_REQ);
        postAPI.login(jsonReq);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(PostAPI.LOGIN);
    }

    @And("Response body should be {string} as token")
    public void responseBodyShouldBeAsToken(String token) {
        SerenityRest.then().body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate login json schema")
    public void validateLoginJsonSchema() {
        File loginSchema = new File(JsonSchema.LOGIN_SCHEMA);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(loginSchema));
    }

//    Invalid login user
    @Given("Login with existing user with invalid json")
    public void loginWithExistingUserWithInvalidJson() {
        File jsonreq = new File(ReqBody.INVALID_LOGIN_REQ);
        postAPI.login(jsonreq);
    }

    @And("Validate unsuccessful login schema")
    public void validateUnsuccessfulLoginSchema() {
        File invalidSchema = new File(JsonSchema.Invalid_LOGIN_SCHEMA);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(invalidSchema));
    }
}
package starter.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqresAPI.PutAPI;
import starter.reqresAPI.utilities.JsonSchema;
import starter.reqresAPI.utilities.ReqresResponses;
import starter.reqresAPI.utilities.ReqBody;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUserPut {
    @Steps
    PutAPI putAPI;

    @Given("Update existing user with valid json and parameter id {int}")
    public void updateExistingUserWithValidJsonAndParameterIdPage(int id) {
        File jsonReq = new File(ReqBody.UPDATE_USER_REQ);
        putAPI.putUpdateUser(jsonReq, id);
    }

    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when().put(PutAPI.UPDATE_USER);
    }

    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Validate put user schema")
    public void validatePutUserSchema() {
        File jsonSchema = new File(JsonSchema.UPDATE_USER_SCHEMA);
    }


    @Given("Update existing user with valid json and invalid parameter id {string}")
    public void updateExistingUserWithValidJsonAndInvalidParameterId(String id) {
        File jsonReq = new File(ReqBody.UPDATE_USER_REQ);
        putAPI.putUpdateInvalidUser(jsonReq, id);
    }
}

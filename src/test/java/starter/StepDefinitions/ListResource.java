package starter.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqresAPI.GetAPI;
import starter.reqresAPI.utilities.JsonSchema;

import java.io.File;

public class ListResource {
    @Steps
    GetAPI getAPI;

    @Given("Get list resource")
    public void getListResource() {
        getAPI.getListResource();
    }

    @When("Send request get list resource")
    public void sendRequestGetListResource() {
        SerenityRest.when().get(GetAPI.GET_LIST_RESOURCE);
    }

    @And("Validate get list resource schema")
    public void validateGetListResourceSchema() {
        File listResourceSchema = new File(JsonSchema.LIST_RESOURCE);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(listResourceSchema));
    }
}

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

public class SingleResources {
    @Steps
    GetAPI getAPI;

//    Valid single resources
    @Given("Get single resources with valid parameter {int}")
    public void getSingleResourcesWithValidParameterId(int id) {
        getAPI.getSingleResourceUser(id);
    }

    @When("Send request get single resources")
    public void sendRequestGetSingleResources() {
        SerenityRest.when().get(GetAPI.GET_SINGLE_RESOURCE);
    }

    @And("Validate get single resource schema")
    public void validateGetSingleResourceSchema() {
        File jsonSchema = new File(JsonSchema.SINGLE_RESOURCES_SCHEMA);
    }

//    Invalid single resources
    @Given("Get single resources with invalid parameter {string}")
    public void getSingleResourcesWithInvalidParameter(String id) {
        getAPI.getInvalidSingleResourceUser(id);
    }

}

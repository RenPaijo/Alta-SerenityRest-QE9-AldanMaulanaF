package starter.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqresAPI.DeleteAPI;

public class DeleteUser {
    @Steps
    DeleteAPI deleteAPI;

//    Delete valid user
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        deleteAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(DeleteAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

//    Delete invalid user
    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        deleteAPI.deleteInvalidUser(id);
    }
}

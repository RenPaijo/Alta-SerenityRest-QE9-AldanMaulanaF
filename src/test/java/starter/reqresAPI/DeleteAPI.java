package starter.reqresAPI;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DeleteAPI extends Base {
    public static String DELETE_USER = BASE_URL + "/api/users/{id}";

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete invalid user")
    public void deleteInvalidUser(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}

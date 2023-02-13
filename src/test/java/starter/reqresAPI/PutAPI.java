package starter.reqresAPI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqresAPI.Base;

import java.io.File;

public class PutAPI extends Base {
    public static String UPDATE_USER = BASE_URL + "/api/users/{id}";

    @Step("Put valid user")
    public void putUpdateUser(File json, int id){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }

    @Step("Put valid user and invalid id")
    public void putUpdateInvalidUser(File json, String id){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }
}

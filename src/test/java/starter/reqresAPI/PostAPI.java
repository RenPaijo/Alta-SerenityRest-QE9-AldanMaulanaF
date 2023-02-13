package starter.reqresAPI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class PostAPI extends Base {
    public static String REGISTER = BASE_URL + "/api/register";
    public static String LOGIN = BASE_URL + "/api/login";

    @Step("Post register user account")
    public void register( File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Post login user")
    public void login( File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}

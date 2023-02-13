package starter.reqresAPI;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetAPI extends Base {
    public static String SINGLE_USER = BASE_URL + "/api/users/{id}";

    public static String GET_LIST_USER = BASE_URL + "/api/users?page={page}";

    public static String GET_LIST_RESOURCE= BASE_URL + "/api/unknown";

    public static String GET_SINGLE_RESOURCE= BASE_URL + "/api/unknown/{id}";

    @Step("Get single valid user")
    public void getSingleUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single invalid user")
    public void getSingleInvalidUser(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get list valid user")
    public void getListUser(int page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get list invalid user")
    public void getListInvalidUser(String page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get list resource")
    public void getListResource(){
        SerenityRest.given();
    }

    @Step("Get  valid single resource user")
    public void getSingleResourceUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get  invalid single resource user")
    public void getInvalidSingleResourceUser(String id){
        SerenityRest.given().pathParam("id", id);
    }
}
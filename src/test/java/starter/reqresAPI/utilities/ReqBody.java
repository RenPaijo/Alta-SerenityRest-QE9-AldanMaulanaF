package starter.reqresAPI.utilities;

import starter.reqresAPI.Base;

public class ReqBody extends Base {

    public static String REGISTER_REQ = DIR + "/src/test/resources/features/JSON/ReqBody/Register.json";
    public static String INVALID_REGISTER_REQ = DIR + "/src/test/resources/features/JSON/" +
            "ReqBody/InvalidRegister.json";
    public static String UPDATE_USER_REQ = DIR + "/src/test/resources/features/JSON/" +
            "ReqBody/UpdateUser.json";

    public static String LOGIN_REQ = DIR + "/src/test/resources/features/JSON/ReqBody/Login.json";

    public static String INVALID_LOGIN_REQ = DIR + "/src/test/resources/features/JSON/" +
            "ReqBody/InvalidLogin.json";
}

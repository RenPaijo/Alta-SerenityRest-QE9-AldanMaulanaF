package starter.reqresAPI.utilities;

import starter.reqresAPI.Base;

public class JsonSchema extends Base {
    public static String SINGLE_USER_SCHEMA = DIR + "/src/test/resources/features/JSON/" +
            "JsonSchema/SingleUser.json";

    public static String REGISTER_SCHEMA = DIR + "/src/test/resources/features/JSON/" +
            "JsonSchema/Register.json";

    public static String Invalid_REGISTER_SCHEMA = DIR + "/src/test/resources/features/JSON/" +
            "JsonSchema/InvalidRegister.json";

    public static String UPDATE_USER_SCHEMA = DIR + "/src/test/resources/features/JSON/" +
            "JsonSchema/UpdateUserSchema.json";

    public static String LOGIN_SCHEMA = DIR + "/src/test/resources/features/JSON/" +
            "JsonSchema/LoginSchema.json";

    public static String Invalid_LOGIN_SCHEMA = DIR + "/src/test/resources/features/JSON/" +
            "JsonSchema/InvalidLoginSchema.json";

    public static String LIST_USER = DIR + "/src/test/resources/features/JSON/" +
            "JsonSchema/ListUser.json";

    public static String LIST_RESOURCE = DIR + "/src/test/resources/features/JSON/" +
            "JsonSchema/ListResource.json";

    public static String SINGLE_RESOURCES_SCHEMA = DIR + "/src/test/resources/features/JSON/" +
            "JsonSchema/SingleResourcesSchema.json";
}

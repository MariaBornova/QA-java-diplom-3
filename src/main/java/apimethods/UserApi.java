package apimethods;

import static data.Url.*;
import io.qameta.allure.Step;
import io.restassured.response.Response;


public class UserApi {

    @Step("User create")
    public static void create(User user) {
        getSpec()
                .body(user)
                .when()
                .post(USER_REGISTER);
    }


    @Step("User authorized")
    public static Response login(User user) {
        return getSpec()
                .body(user)
                .when()
                .post(USER_LOGIN);
    }
    @Step("User delete")
    public static void delete(String accessToken) {
        getSpec()
                .header("Authorization", accessToken)
                .when()
                .delete(USER);
    }
}

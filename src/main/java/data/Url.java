package data;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Url {
    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String FORGOT_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final String USER_REGISTER = "api/auth/register";
    public static final String USER = "api/auth/user";
    public static final String USER_LOGIN = "/api/auth/login";
    public static final String BROWSER_YANDEX = "yandex";
    public static final String BROWSER_CHROME = "chrome";
    public static RequestSpecification getSpec() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .log()
                .all();

    }
}

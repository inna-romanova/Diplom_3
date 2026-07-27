package user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.User;
import data.ApiConstants;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class UserClient {
    private final RequestSpecification spec;

    public UserClient() {
        RestAssured.baseURI = ApiConstants.BASE_URL;
        this.spec = RestAssured.given().contentType(ContentType.JSON);
    }

    @Step("Отправка POST-запроса для логина пользователя")
    public Response login(User user) {
        return given()
                .spec(spec)
                .body(user)
                .post(ApiConstants.LOGIN_PATH);
    }

    @Step("Отправка DELETE-запроса для удаления пользователя")
    public Response delete(String bearerToken) {
        if (bearerToken == null || bearerToken.isEmpty()) {
            return null;
        }

        return given()
                .spec(spec)
                .header("Authorization", bearerToken)
                .delete(ApiConstants.DELETE_USER_PATH);
    }

    @Step("Отправка POST-запроса на создание пользователя")
    public Response create(User user) {
        return given()
                .spec(spec)
                .body(user)
                .post(ApiConstants.CREATE_USER_PATH);
    }
}

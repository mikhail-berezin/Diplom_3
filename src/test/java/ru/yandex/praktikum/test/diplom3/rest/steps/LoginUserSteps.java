package ru.yandex.praktikum.test.diplom3.rest.steps;

import io.restassured.response.Response;
import ru.yandex.praktikum.test.diplom3.rest.dto.LoginUserDto;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;
import static ru.yandex.praktikum.test.diplom3.rest.constants.StellarburgerRestConstants.JSON_CONTENT_TYPE;
import static ru.yandex.praktikum.test.diplom3.rest.constants.StellarburgerRestConstants.LOGIN_USER_ENDPOINT;

public class LoginUserSteps {

    public static Response loginUser(LoginUserDto loginUserDto) {
        return given()
                .header(CONTENT_TYPE, JSON_CONTENT_TYPE)
                .and().body(loginUserDto)
                .post(LOGIN_USER_ENDPOINT);
    }
}

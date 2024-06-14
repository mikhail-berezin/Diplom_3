package ru.yandex.praktikum.test.diplom3.rest.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.yandex.praktikum.test.diplom3.rest.dto.RegisterUserDto;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;
import static ru.yandex.praktikum.test.diplom3.rest.constants.StellarburgerRestConstants.JSON_CONTENT_TYPE;
import static ru.yandex.praktikum.test.diplom3.rest.constants.StellarburgerRestConstants.REGISTER_USER_ENDPOINT;

public class RegisterUserSteps {

    @Step("POST request to /api/auth/register")
    public static Response registerUser(RegisterUserDto registerUserDto) {
        return given()
                .header(CONTENT_TYPE, JSON_CONTENT_TYPE)
                .and().body(registerUserDto)
                .post(REGISTER_USER_ENDPOINT);
    }
}

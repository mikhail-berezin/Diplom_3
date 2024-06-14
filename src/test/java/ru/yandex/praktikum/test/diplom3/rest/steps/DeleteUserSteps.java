package ru.yandex.praktikum.test.diplom3.rest.steps;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class DeleteUserSteps {

    @Step
    public static void deleteUser(String token) {
        if (token != null) {
            given().auth().oauth2(token).delete("/api/auth/user");
        }
    }
}

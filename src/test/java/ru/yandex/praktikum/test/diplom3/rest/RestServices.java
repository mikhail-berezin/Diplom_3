package ru.yandex.praktikum.test.diplom3.rest;

import io.restassured.RestAssured;
import ru.yandex.praktikum.test.diplom3.rest.dto.LoginResponse;
import ru.yandex.praktikum.test.diplom3.rest.dto.LoginUserDto;
import ru.yandex.praktikum.test.diplom3.rest.dto.RegisterUserDto;

import static ru.yandex.praktikum.test.diplom3.rest.constants.StellarburgerRestConstants.STELLARBURGER_URL;
import static ru.yandex.praktikum.test.diplom3.rest.steps.DeleteUserSteps.deleteUser;
import static ru.yandex.praktikum.test.diplom3.rest.steps.LoginUserSteps.loginUser;
import static ru.yandex.praktikum.test.diplom3.rest.steps.RegisterUserSteps.registerUser;

public class RestServices {

    public static void createUser(String email, String password, String name) {
        RestAssured.baseURI = STELLARBURGER_URL;
        RegisterUserDto registerUserDto = new RegisterUserDto(email, password, name);
        registerUser(registerUserDto);
    }

    public static void clearUserByEmailAndPassword(String email, String password) {
        RestAssured.baseURI = STELLARBURGER_URL;
        LoginUserDto loginUserDto = new LoginUserDto(email, password);
        String userToken = loginUser(loginUserDto).as(LoginResponse.class).getAccessToken();
        if (userToken != null) deleteUser(userToken);
    }
}
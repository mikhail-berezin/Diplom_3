package ru.yandex.praktikum.test.diplom3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import ru.yandex.praktikum.test.diplom3.factory.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import ru.yandex.praktikum.test.diplom3.pageobjects.LoginPage;
import ru.yandex.praktikum.test.diplom3.pageobjects.RegisterPage;

import static ru.yandex.praktikum.test.diplom3.constants.StellarburgersWebServiceConstants.*;
import static ru.yandex.praktikum.test.diplom3.rest.RestServices.clearUserByEmailAndPassword;
import static ru.yandex.praktikum.test.diplom3.service.EmailService.generateEmail;

public class RegistrationTest {

    private String email;

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    RegisterPage registerPage = new RegisterPage(driverFactory.getDriver());
    LoginPage loginPage = new LoginPage(driverFactory.getDriver());

    @Before
    public void init() {
        email = generateEmail();
    }

    @Test
    @DisplayName("Registration with correct data test")
    @Description("Check if login button is visible after registration with correct data")
    public void registrationWithCorrectDataTest() {

        driverFactory.getDriver().get(MAIN_PAGE_URL + REGISTER_PATH);

        registerPage.inputName(STANDARD_NAME);
        registerPage.inputEmail(email);
        registerPage.inputPassword(STANDARD_PASSWORD);
        registerPage.clickRegisterButton();
        loginPage.checkLoginButtonIsVisible();
    }

    @Test
    @DisplayName("Registration with too short password test")
    @Description("Check if login button is not visible after registration with too short password")
    public void RegistrationWithTooShortPasswordTest() {

        driverFactory.getDriver().get(MAIN_PAGE_URL + REGISTER_PATH);

        registerPage.inputName(STANDARD_NAME);
        registerPage.inputEmail(email);
        registerPage.inputPassword(TOO_SHORT_PASSWORD);
        registerPage.clickRegisterButton();
        loginPage.checkLoginButtonIsInvisible();
    }

    @After
    public void clearUser() {
        clearUserByEmailAndPassword(email, STANDARD_PASSWORD);
        clearUserByEmailAndPassword(email, TOO_SHORT_PASSWORD);
    }
}
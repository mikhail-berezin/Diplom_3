package ru.yandex.praktikum.test.diplom3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import ru.yandex.praktikum.test.diplom3.factory.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import ru.yandex.praktikum.test.diplom3.pageobjects.ForgotPasswordPage;
import ru.yandex.praktikum.test.diplom3.pageobjects.LoginPage;
import ru.yandex.praktikum.test.diplom3.pageobjects.MainPage;
import ru.yandex.praktikum.test.diplom3.pageobjects.RegisterPage;

import static ru.yandex.praktikum.test.diplom3.constants.StellarburgersWebServiceConstants.*;
import static ru.yandex.praktikum.test.diplom3.rest.RestServices.clearUserByEmailAndPassword;
import static ru.yandex.praktikum.test.diplom3.rest.RestServices.createUser;
import static ru.yandex.praktikum.test.diplom3.service.EmailService.generateEmail;

public class LoginTest {

    private String email;

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    MainPage mainPage = new MainPage(driverFactory.getDriver());
    LoginPage loginPage = new LoginPage(driverFactory.getDriver());
    RegisterPage registerPage = new RegisterPage(driverFactory.getDriver());
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverFactory.getDriver());

    @Before
    public void init() {
        email = generateEmail();
        createUser(email, STANDARD_PASSWORD, STANDARD_NAME);
    }

    @Test
    @DisplayName("Logging in with logging in button test")
    @Description("Check if create order button is visible after logging in via logging in button")
    public void loggingInWithLoggingInButtonTest() {
        driverFactory.getDriver().get(MAIN_PAGE_URL);

        mainPage.clickLoggingInButton();
        loginPage.inputDataAndClickLoginButton(email);
        mainPage.checkCreateOrderButtonIsVisible();
    }

    @Test
    @DisplayName("Logging in with account button test")
    @Description("Check if create order button is visible after logging in via account button")
    public void loggingInWithAccountButtonTest() {
        driverFactory.getDriver().get(MAIN_PAGE_URL);

        mainPage.clickAccountButton();
        loginPage.inputDataAndClickLoginButton(email);
        mainPage.checkCreateOrderButtonIsVisible();
    }

    @Test
    @DisplayName("Logging in via registration page test")
    @Description("Check if create order button is visible after logging in via registration page")
    public void loggingInViaRegistrationPageTest() {
        driverFactory.getDriver().get(MAIN_PAGE_URL + REGISTER_PATH);
        registerPage.clickLoginLink();
        loginPage.inputDataAndClickLoginButton(email);
        mainPage.checkCreateOrderButtonIsVisible();
    }

    @Test
    @DisplayName("Logging in via forgot password page test")
    @Description("Check if create order button is visible after logging in via forgot password page")
    public void loggingInViaForgotPasswordPageTest() {
        driverFactory.getDriver().get(MAIN_PAGE_URL + FORGOT_PASSWORD_PATH);

        forgotPasswordPage.clickLoginLink();
        loginPage.inputDataAndClickLoginButton(email);
        mainPage.checkCreateOrderButtonIsVisible();
    }

    @After
    public void clearUser() {
        clearUserByEmailAndPassword(email, STANDARD_PASSWORD);
    }
}
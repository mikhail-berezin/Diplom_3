package ru.yandex.praktikum.test.diplom3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import ru.yandex.praktikum.test.diplom3.factory.DriverFactory;
import ru.yandex.praktikum.test.diplom3.pageobjects.LoginPage;
import ru.yandex.praktikum.test.diplom3.pageobjects.MainPage;
import ru.yandex.praktikum.test.diplom3.pageobjects.ProfilePage;

import static ru.yandex.praktikum.test.diplom3.constants.StellarburgersWebServiceConstants.*;
import static ru.yandex.praktikum.test.diplom3.rest.RestServices.clearUserByEmailAndPassword;
import static ru.yandex.praktikum.test.diplom3.rest.RestServices.createUser;
import static ru.yandex.praktikum.test.diplom3.service.EmailService.generateEmail;

public class LogoutTest {

    private String email;

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    MainPage mainPage = new MainPage(driverFactory.getDriver());
    LoginPage loginPage = new LoginPage(driverFactory.getDriver());
    ProfilePage profilePage = new ProfilePage(driverFactory.getDriver());

    @Before
    public void init() {
        email = generateEmail();
        createUser(email, STANDARD_PASSWORD, STANDARD_NAME);

        driverFactory.getDriver().get(MAIN_PAGE_URL + LOGIN_PATH);

        loginPage.inputDataAndClickLoginButton(email);
        mainPage.clickAccountButton();
    }

    @Test
    @DisplayName("Logging out test")
    @Description("Checking if logging in button is visible after clicking log out button")
    public void loggingOutTest() {
        profilePage.clickLogoutButton();
        loginPage.checkLoginButtonIsVisible();
    }

    @After
    public void clearUser() {
        clearUserByEmailAndPassword(email, STANDARD_PASSWORD);
    }
}
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
import static ru.yandex.praktikum.test.diplom3.constants.StellarburgersWebServiceConstants.STANDARD_PASSWORD;
import static ru.yandex.praktikum.test.diplom3.rest.RestServices.clearUserByEmailAndPassword;
import static ru.yandex.praktikum.test.diplom3.rest.RestServices.createUser;
import static ru.yandex.praktikum.test.diplom3.service.EmailService.generateEmail;

public class OpeningConstructorTest {

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
    @DisplayName("Open constructor via button test")
    @Description("Check if assemble burger header is visible after clicking constructor button")
    public void openConstructorViaButtonTest() {
        profilePage.clickConstructorButton();
        mainPage.checkAssembleBurgerIsVisible();
    }

    @Test
    @DisplayName("Open constructor via logo test")
    @Description("Check if assemble burger header is visible after clicking logo")
    public void openConstructorViaLogoTest() {
        profilePage.clickLogo();
        mainPage.checkAssembleBurgerIsVisible();
    }

    @After
    public void clearUser() {
        clearUserByEmailAndPassword(email, STANDARD_PASSWORD);
    }
}
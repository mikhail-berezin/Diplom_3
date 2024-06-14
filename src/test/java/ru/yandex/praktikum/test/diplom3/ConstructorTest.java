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

import static ru.yandex.praktikum.test.diplom3.constants.StellarburgersWebServiceConstants.*;
import static ru.yandex.praktikum.test.diplom3.rest.RestServices.clearUserByEmailAndPassword;
import static ru.yandex.praktikum.test.diplom3.rest.RestServices.createUser;
import static ru.yandex.praktikum.test.diplom3.service.EmailService.generateEmail;

public class ConstructorTest {

    private String email;

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    MainPage mainPage = new MainPage(driverFactory.getDriver());
    LoginPage loginPage = new LoginPage(driverFactory.getDriver());

    @Before
    public void init() {
        email = generateEmail();
        createUser(email, STANDARD_PASSWORD, STANDARD_NAME);

        driverFactory.getDriver().get(MAIN_PAGE_URL + LOGIN_PATH);

        loginPage.inputDataAndClickLoginButton(email);
    }

    @Test
    @DisplayName("Sauces can be selected test")
    @Description("Check if sauces selected after click")
    public void saucesCanBeSelectedTest() {
        mainPage.clickSauces();
        mainPage.checkSaucesIsSelected();
    }

    @Test
    @DisplayName("Fillings can be selected test")
    @Description("Check if fillings selected after click")
    public void checkFillingsCanBeSelected() {
        mainPage.clickFillings();
        mainPage.checkFillingsIsSelected();
    }

    @Test
    @DisplayName("Buns can be selected test")
    @Description("Check if buns selected after click")
    public void checkBunsCanBeSelected() {
        mainPage.clickSauces();
        mainPage.checkSaucesIsSelected(); // to be sure that another tab is selected
        mainPage.clickBuns();
        mainPage.checkBunsIsSelected();
    }

    @After
    public void clearUser() {
        clearUserByEmailAndPassword(email, STANDARD_PASSWORD);
    }
}
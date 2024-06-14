package ru.yandex.praktikum.test.diplom3.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static ru.yandex.praktikum.test.diplom3.constants.StellarburgersWebServiceConstants.STANDARD_PASSWORD;

public class LoginPage {

    private final WebDriver driver;

    private final By emailInput = By.xpath("//label[text() = 'Email']/following-sibling::input");
    private final By passwordInput = By.xpath("//label[text() = 'Пароль']/following-sibling::input");
    private final By loginButton = By.xpath("//button[text() = 'Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputDataAndClickLoginButton(String email) {
        inputEmail(email);
        inputPassword(STANDARD_PASSWORD);
        clickLoginButton();
    }

    private void inputEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    private void inputPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    private void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void checkLoginButtonIsVisible() {
        new WebDriverWait(driver, 8).until(visibilityOfElementLocated(loginButton));
    }

    public void checkLoginButtonIsInvisible() {
        new WebDriverWait(driver, 8).until(invisibilityOfElementLocated(loginButton));
    }
}
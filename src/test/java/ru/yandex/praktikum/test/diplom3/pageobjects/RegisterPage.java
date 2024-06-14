package ru.yandex.praktikum.test.diplom3.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final WebDriver driver;

    private final By nameInput = By.xpath("//label[text() = 'Имя']/following-sibling::input");
    private final By emailInput = By.xpath("//label[text() = 'Email']/following-sibling::input");
    private final By passwordInput = By.xpath("//label[text() = 'Пароль']/following-sibling::input");
    private final By registerButton = By.xpath("//button[text() = 'Зарегистрироваться']");
    private final By loginA = By.xpath("//a[text() = 'Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void inputEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginA).click();
    }
}
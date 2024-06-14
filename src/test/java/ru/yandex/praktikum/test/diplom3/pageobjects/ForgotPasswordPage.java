package ru.yandex.praktikum.test.diplom3.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {


    private final WebDriver driver;

    private final By loginA = By.xpath("//a[text() = 'Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginLink() {
        driver.findElement(loginA).click();
    }
}

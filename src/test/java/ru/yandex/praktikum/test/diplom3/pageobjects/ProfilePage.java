package ru.yandex.praktikum.test.diplom3.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProfilePage {

    private final WebDriver driver;

    private final By pageDescriptionP = By.xpath("//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");
    private final By constructorP = By.xpath(    "//p[text() = 'Конструктор']");
    private final By logoA = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]/a");
    private final By logoutButton = By.xpath("//button[text() = 'Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkPageDescriptionIsVisible() {
        new WebDriverWait(driver, 8).until(visibilityOfElementLocated(pageDescriptionP));
    }

    public void clickConstructorButton() {
        new WebDriverWait(driver, 8).until(visibilityOfElementLocated(constructorP));
        driver.findElement(constructorP).click();
    }

    public void clickLogo() {
        driver.findElement(logoA).click();
    }

    public void clickLogoutButton() {
        new WebDriverWait(driver, 8).until(visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }
}
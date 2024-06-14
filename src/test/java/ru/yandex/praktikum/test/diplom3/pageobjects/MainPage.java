package ru.yandex.praktikum.test.diplom3.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MainPage {

    private final WebDriver driver;

    private final By accountP = By.xpath("//p[text()='Личный Кабинет']");
    private final By loggingInButton = By.xpath("//button[text() = 'Войти в аккаунт']");
    private final By createOrderButton = By.xpath("//button[text() = 'Оформить заказ']");
    private final By assembleBurgerH1 = By.xpath("//h1[text() = 'Соберите бургер']");
    private final By saucesSpan = By.xpath("//span[text() = 'Соусы']");
    private final By saucesDiv = By.xpath("//span[text() = 'Соусы']/parent::div");
    private final By fillingsSpan = By.xpath("//span[text() = 'Начинки']");
    private final By fillingsDiv = By.xpath("//span[text() = 'Начинки']/parent::div");
    private final By bunsSpan = By.xpath("//span[text() = 'Булки']");
    private final By bunsDiv = By.xpath("//span[text() = 'Булки']/parent::div");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAccountButton() {
        new WebDriverWait(driver, 8).until(elementToBeClickable(accountP));
        driver.findElement(accountP).click();
    }

    public void clickLoggingInButton() {
        driver.findElement(loggingInButton).click();
    }

    public void checkCreateOrderButtonIsVisible() {
        new WebDriverWait(driver, 8).until(visibilityOfElementLocated(createOrderButton));
    }

    public void checkAssembleBurgerIsVisible() {
        new WebDriverWait(driver, 8).until(visibilityOfElementLocated(assembleBurgerH1));
    }

    public void clickSauces() {
        new WebDriverWait(driver, 8).until(visibilityOfElementLocated(saucesSpan));
        driver.findElement(saucesSpan).click();
    }

    public void clickFillings() {
        new WebDriverWait(driver, 8).until(visibilityOfElementLocated(fillingsSpan));
        driver.findElement(fillingsSpan).click();
    }

    public void clickBuns() {
        new WebDriverWait(driver, 8).until(visibilityOfElementLocated(bunsSpan));
        driver.findElement(bunsSpan).click();
    }

    public void checkSaucesIsSelected() {
        new WebDriverWait(driver, 8)
                .until(attributeContains(saucesDiv, "class", "current"));
    }

    public void checkFillingsIsSelected() {
        new WebDriverWait(driver, 8)
                .until(attributeContains(fillingsDiv, "class", "current"));
    }

    public void checkBunsIsSelected() {
        new WebDriverWait(driver, 8)
                .until(attributeContains(bunsDiv, "class", "current"));
    }
}
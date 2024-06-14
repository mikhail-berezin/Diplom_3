package ru.yandex.praktikum.test.diplom3.factory;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory extends ExternalResource {

    private final WebDriver driver;

    public DriverFactory() {

//        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\yandexdriver.exe");
        driver = new ChromeDriver();
    }

    @Override
    protected void after()  {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
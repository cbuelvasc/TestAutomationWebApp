package com.company.driver.strategy;

import com.company.annottation.FirefoxConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FirefoxConfig
public class FirefoxDriverConfig implements DriverConfig {

    private WebDriver driver;

    public FirefoxDriverConfig() {
        super();
    }

    @Override
    public WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        return driver;
    }
}

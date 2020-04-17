package com.company.driver.strategy;

import com.company.annottation.SafaryConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

@SafaryConfig
public class SafaryDriverConfig implements DriverConfig {

    private WebDriver driver;

    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new SafariDriver();
        this.driver.manage().window().maximize();
        return driver;
    }
}

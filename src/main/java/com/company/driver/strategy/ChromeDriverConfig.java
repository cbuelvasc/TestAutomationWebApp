package com.company.driver.strategy;

import com.company.annottation.ChromeConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@ChromeConfig
public class ChromeDriverConfig implements DriverConfig {

    private WebDriver driver;

    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        return driver;
    }
}

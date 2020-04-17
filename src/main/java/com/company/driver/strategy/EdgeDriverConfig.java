package com.company.driver.strategy;

import com.company.annottation.EdgeConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

@EdgeConfig
public class EdgeDriverConfig implements DriverConfig {

    private WebDriver driver;

    @Override
    public WebDriver getDriver() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        this.driver.manage().window().maximize();
        return driver;
    }
}

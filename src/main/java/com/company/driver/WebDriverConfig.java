package com.company.driver;

import com.company.driver.strategy.DriverConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.company.*")
public class WebDriverConfig {

    @Autowired
    private DriverConfig driverConfig;

    @Bean(destroyMethod = "quit")
    @Qualifier("webDriver")
    public WebDriver getWebDriver() {
        return driverConfig.getDriver();
    }
}

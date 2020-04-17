package com.company.Service;

import com.company.page.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Service
public class ServicePage<T extends BasePage> {

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private ApplicationContext appContext;

    private T entityClass;

    public static final int FAST_CHECK = 3;

    @SuppressWarnings("unchecked")
    private Class<T> getParameterizedType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T getEntityClass() {
        return entityClass;
    }

    public WebDriverWait getWebDriverWait(final int timeoutInSeconds) {
        return (WebDriverWait) new WebDriverWait(webDriver, timeoutInSeconds);
    }

    public <K> FluentWait<K> getFluentWait(K object, int timeOutSeconds) {
        return new FluentWait<>(object)
                .withTimeout(Duration.of(timeOutSeconds, ChronoUnit.SECONDS))
                .pollingEvery(Duration.of(1, ChronoUnit.SECONDS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public void click(WebElement element) {
        getFluentWait(webDriver, 5).until(elementToBeClickable(element))
                .click();
    }

    public void type(WebElement element, String text) {
        getFluentWait(webDriver, 5).until(elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        return getFluentWait(webDriver, 5).until(visibilityOf(element)).getText();
    }

    public WebElement getElementByXpathwithText(String text){
        return getFluentWait(webDriver, 10).until(visibilityOfElementLocated(By.xpath(String.format("//*[contains(text() = '%s')]", text))));
    }

    public WebElement getElementBy(By by){
        return getFluentWait(webDriver, 10).until(visibilityOfElementLocated(by));
    }
}

package com.company.pages;

import com.company.annottation.Page;
import com.company.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Page
public class SignUpPage extends BasePage {

    @FindBy(xpath = "//*[text() = 'Crear cuenta']")
    private WebElement title;

    @FindBy(id = "id_nombre")
    private WebElement name;

    @FindBy(id = "id_apellido")
    private WebElement lastName;

    @FindBy(id = "id_email")
    private WebElement email;

    @FindBy(xpath= "//span[contains(@class,'error')]")
    private List<WebElement> listMessage;

    @FindBy(id = "id_password")
    private WebElement password;

    @FindBy( xpath= "//*[@name = 'birthdate']")
    private WebElement birthdate;

    @FindBy( xpath= "//span/button[@class='btn btn-default']")
    private WebElement buttonBirthDate;

    @FindBy( xpath= "//div[5]/p/div/ul")
    private WebElement datePicker;

    @FindBy( xpath= "//*[@name = 'woman']")
    private WebElement radioWoman;

    @FindBy( xpath= "//*[@name = 'man']")
    private WebElement radioMan;

    @FindBy( xpath= "//button[text()='Crear cuenta']")
    private WebElement buttonCreateAccount;

    @Autowired
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public List<WebElement> getListMessage() {
        return listMessage;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getBirthdate() {
        return birthdate;
    }

    public WebElement getButtonBirthDate() {
        return buttonBirthDate;
    }

    public WebElement getDatePicker() {
        return datePicker;
    }

    public WebElement getRadioWoman() {
        return radioWoman;
    }

    public WebElement getRadioMan() {
        return radioMan;
    }

    public WebElement getButtonCreateAccount() {
        return buttonCreateAccount;
    }
}

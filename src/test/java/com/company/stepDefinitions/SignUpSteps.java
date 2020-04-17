package com.company.stepDefinitions;

import com.company.Service.ServicePage;
import com.company.driver.WebDriverConfig;
import com.company.model.User;
import com.company.pages.SignUpPage;
import com.company.util.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles(Browser.CHROME)
@ContextConfiguration(classes = {WebDriverConfig.class}, loader = AnnotationConfigContextLoader.class)
@TestExecutionListeners(inheritListeners = false, listeners = {
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
public class SignUpSteps extends AbstractTestNGSpringContextTests {

    private User user;

    @Autowired
    private SignUpPage signUpPage;

    @Autowired
    private ServicePage<SignUpPage> servicePage;

    @Autowired
    private WebDriver webDriver;

    @Given("^I start sign up page$")
    public void i_start_sign_up_page() {
        webDriver.get("http://3.87.50.247:3000/#/");
        assertThat(servicePage.getText(signUpPage.getTitle())).as("Title page isn't present").isEqualTo("Crear cuenta");
    }

    @When("^I fill with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_fill_with(String name, String lastName, String email, String password, String birthdate) {
        servicePage.type(signUpPage.getName(), name);
        servicePage.type(signUpPage.getLastName(), lastName);
        servicePage.type(signUpPage.getEmail(), email);
        servicePage.type(signUpPage.getPassword(), password);
        servicePage.type(signUpPage.getBirthdate(), birthdate);
    }

    @And("^I selected gendre \"([^\"]*)\"$")
    public void i_selected_gendre(String gendre) {
        if (gendre.equals("man")) {
            servicePage.click(signUpPage.getRadioMan());
        } else {
            servicePage.click(signUpPage.getRadioWoman());
        }
    }

    @And("^I click in create account$")
    public void i_click_in_create_account() {
        servicePage.click(signUpPage.getButtonCreateAccount());
    }

    @Then("^I expect to get alert with \"([^\"]*)\" message$")
    public void i_expect_to_get_alert_message(String message) {
            assertThat(webDriver.switchTo().alert().getText()).as("").isEqualTo(message);
            webDriver.switchTo().alert().accept();
    }

    @Then("^I expect to get \"([^\"]*)\" message$")
    public void i_expect_to_get_message(String message) {
            assertThat(signUpPage.getListMessage()
                    .stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList()))
                    .as("Message error isn't present")
                    .contains(message);
    }
}

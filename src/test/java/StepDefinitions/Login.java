package StepDefinitions;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Login extends CommonMethods {
    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {
        sendText(login.usernameTextBox,ConfigReader.getPropertyValue("username"));
        sendText(login.passwordTextBox,ConfigReader.getPropertyValue("password"));
    }
    @When("click on login button")
    public void click_on_login_button() {
        doClick(login.loginBtn);
    }
    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {
        boolean userloggedIn = driver.findElement(By.xpath("//a[contains(text(), 'Welcome')]")).isDisplayed();
        if (userloggedIn) {
            System.out.println("User is logged in Successfully");
        }
    }

@When("user enters valid {string} and valid {string}")
public void user_enters_valid_and_valid(String username, String password) {
        sendText(login.usernameTextBox,username);
        sendText(login.passwordTextBox,password);
}

    @When("user enters username and password and verifies login")
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) {


       List<Map<String,String>> userCredentials= dataTable.asMaps();
       for(Map<String,String>userCreds:userCredentials){
           String username=userCreds.get("username");
           String password=userCreds.get("password");
           sendText(login.usernameTextBox,username);
           sendText(login.passwordTextBox,password);
           doClick(login.loginBtn);
           doClick(login.welcomeIcon);
           doClick(login.logoutLink);
       }
    }

    @When("user enter {string} and {string}")
    public void user_enter_and(String username, String password) {
       sendText(login.usernameTextBox, username);
       sendText(login.passwordTextBox,password );
    }

    @Then("user see {string}")
    public void user_see(String errorMessage) {
        Assert.assertEquals("Not correct error message is displayed", errorMessage, login.errorMsg.getText());
    }





}

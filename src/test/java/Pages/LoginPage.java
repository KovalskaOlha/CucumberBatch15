package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



//every page object should inherit the common method class
public class LoginPage extends CommonMethods {
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="txtUsername")
    public WebElement usernameTextBox;
    @FindBy(id="txtPassword")
    public WebElement passwordTextBox;
    @FindBy(id="btnLogin")
    public WebElement  loginBtn;
    @FindBy(id="welcome")
    public WebElement welcomeIcon;
    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutLink;
    @FindBy(id = "spanMessage")
    public WebElement errorMsg;




    // Page Factory Model (Selenium) approach


}

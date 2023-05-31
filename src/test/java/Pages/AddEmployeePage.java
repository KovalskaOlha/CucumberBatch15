package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {
    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimBtn;
    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployee;
    @FindBy(id="firstName")
    public WebElement firstnameTextBox;
    @FindBy(id="middleName")
    public WebElement middlenameTextBox;
    @FindBy(id="lastName")
    public WebElement lastname;
    @FindBy(id="btnSave")
    public WebElement saveBnt;
    @FindBy(id="employeeId")
    public WebElement empIdLocator;


}

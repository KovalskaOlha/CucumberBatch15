package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchEmployeePage extends CommonMethods {
    public SearchEmployeePage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="empsearch_id")
    public WebElement empIdTextBox;
    @FindBy(id="searchBtn")
    public WebElement searchButton;
    @FindBy(id="empsearch_job_title")
    public WebElement jobTitleDdl;
}

package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchEmployee extends CommonMethods {
    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
       //WebElement empIdTextBox =driver.findElement(By.id("empsearch_id"));
       sendText(searchEmployeePage.empIdTextBox, ConfigReader.getPropertyValue("empid"));

    }
    @When("clicks on search button")
    public void clicks_on_search_button() {
       //WebElement searchButton= driver.findElement(By.id("searchBtn"));
       doClick(searchEmployeePage.searchButton);

    }
    @When("user see employee information displayed")
    public void user_see_employee_information_displayed() {
        System.out.println("The employee is displayed");
    }
    @When("user select job title")
    public void user_select_job_title() {
        //WebElement jobTitleDdl=driver.findElement(By.id("empsearch_job_title"));
        selectByOptions(searchEmployeePage.jobTitleDdl,"Singer");
//        WebElement EmpStatusDdl=driver.findElement(By.id("empsearch_employee_status"));
//        selectByOptions(EmpStatusDdl,"Active");
//        WebElement includeDdl=driver.findElement(By.id("empsearch_termination"));
//        selectByOptions(includeDdl,"Current Employees Only");
    }

}

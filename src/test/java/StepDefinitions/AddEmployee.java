package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtility;
import Utils.GlobalVariables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {
    @When("user click on PIM option")
    public void user_click_on_pim_option() {

       doClick(addEmployeePage.pimBtn);

    }
    @When("user click on add employee button")
    public void user_click_on_add_employee_button() {

        doClick(addEmployeePage.addEmployee);
    }
    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {


        sendText(addEmployeePage.firstnameTextBox,ConfigReader.getPropertyValue("firstname"));
        sendText(addEmployeePage.middlenameTextBox,ConfigReader.getPropertyValue("middlename"));
        sendText(addEmployeePage.lastname,ConfigReader.getPropertyValue("lastname"));

    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {

        Assert.assertTrue(addEmployeePage.saveBnt.isDisplayed());
        System.out.println("My assertion is true");
        doClick(addEmployeePage.saveBnt);


    }
    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String fname, String mname, String lastname) {
      sendText(addEmployeePage.firstnameTextBox, fname);
      sendText(addEmployeePage.middlenameTextBox, mname);
      sendText(addEmployeePage.lastname, lastname);
    }
    @When("user captures the employee id")
    public void user_captures_the_employee_id() {
      GlobalVariables.emp_id = addEmployeePage.empIdLocator.getAttribute("value");
        System.out.println("The employee Id is "+ GlobalVariables.emp_id);

    }
    @When("query the information in backend")
    public void query_the_information_in_backend() {
       String query ="select * from hs_hr_employees where employee_id='"+GlobalVariables.emp_id+"'";
       // to store the value from dt
        // in this var we got all keys and values for the emp we searched
       GlobalVariables.tabledata= DBUtility.getListOfMapsFromRset(query);
    }
    @Then("verify the results from frontend and backend")
    public void verify_the_results_from_frontend_and_backend() {
        // now we need to compare one by one value
      String firstNameFromDB=GlobalVariables.tabledata.get(0).get("emp_firstname");
        System.out.println(firstNameFromDB);
        String lastNameFromDB= GlobalVariables.tabledata.get(0).get("emp_lastname");
        System.out.println(lastNameFromDB);
        // adding assertions
        Assert.assertEquals(firstNameFromDB,"nesha");
        Assert.assertEquals(lastNameFromDB,"standart");
    }

}

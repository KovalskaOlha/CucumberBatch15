package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.LoginPage;
import Pages.SearchEmployeePage;

public class PageInitializer {
   public static LoginPage login;
   public static AddEmployeePage addEmployeePage;
   public static SearchEmployeePage searchEmployeePage;
  public static void initializePageObjects()
  //method in which we initialize the login Page
  {
      login=new LoginPage();
      addEmployeePage=new AddEmployeePage();
      searchEmployeePage=new SearchEmployeePage();
  }
}
//This class will manage the object creation of different page Objects in our Framework
//Instead of calling the page objects again, this class will take good care of that step
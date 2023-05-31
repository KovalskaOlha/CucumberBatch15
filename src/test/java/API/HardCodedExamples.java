package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUwMzMzNjcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTA3NjU2NywidXNlcklkIjoiNTIyNCJ9.yGjejffzV9f_bVd0pgB59bOKBjdAUANeqdVaaZPF4hE";
    static String employee_id;
    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id",employee_id);
        Response response=preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        String tempEmpId=response.jsonPath().getString("employee.employee_id");

        //we have 2 emp id --> 1 global and 1 local
        Assert.assertEquals(employee_id,tempEmpId);


    }
    @Test
    public void egetAllEmployeeStatus(){
        RequestSpecification preparedRequest =given().
        header("Content-Type","application/json").
                header("Authorization",token);
        Response response=preparedRequest.when().get("/getAllEmployees.php");
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void fgetJobTitle(){
        RequestSpecification preparedRequest =given().
                header("Content-Type","application/json").
                header("Authorization",token);
        Response response=preparedRequest.when().get("/jobTitle.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void cupdateEmployee(){
        RequestSpecification preparedRequest =given().
                header("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "    \"employee_id\": \""+employee_id+"\",\n" +
                        "    \"emp_firstname\": \"Britney\",\n" +
                        "    \"emp_lastname\": \"Spears\",\n" +
                        "    \"emp_middle_name\": \"Lady\",\n" +
                        "    \"emp_gender\": \"F\",\n" +
                        "    \"emp_birthday\": \"1986-04-21\",\n" +
                        "    \"emp_status\": \"Retired\",\n" +
                        "    \"emp_job_title\": \"Singer\"\n" +
                        "}");
        Response response=preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));
    }
    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id",employee_id);
        Response response=preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //if you want to verify the body of the response you can di that using hamcrest

    }
     @Test
    public void acreateEmployee(){
        //prepare the request
         // RequestSpecification interface
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "    \"emp_firstname\": \"Sam\",\n" +
                        "    \"emp_lastname\": \"Johns\",\n" +
                        "    \"emp_middle_name\": \"J\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"1990-05-20\",\n" +
                        "    \"emp_status\": \"Confirmed\",\n" +
                        "    \"emp_job_title\": \"Engineer\"\n" +
                        "}");

        //hitting the end point/ send the request
        Response response =preparedRequest.when().post("/createEmployee.php");
         response.prettyPrint();
        //verifying the assertions /get response
        response.then().assertThat().statusCode(201);
        //we are capturing emp ID from response
         employee_id=response.jsonPath().getString("Employee.employee_id");
         System.out.println(employee_id);
         response.then().assertThat().
                 body("Employee.emp_firstname", equalTo("Sam"));
         // we can verify the response headers
         response.then().assertThat().header("Content-Type", "application/json");

         System.out.println("My test case is passed");

        // cucumber needs junit support to run the class @Test


    }

}

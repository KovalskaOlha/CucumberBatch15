package APIStepDefinition;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;
    @Given("a JW is generated")
    public void a_jw_is_generated() {
        RequestSpecification generateTokenRequest = given().
                header("Content-Type","application/json").
                body("{\n" +
                        "    \"email\": \"adminnn15@test.com\",\n" +
                        "    \"password\": \"password123\"\n" +
                        "}");
        Response response = generateTokenRequest.when().post("/generateToken.php");
        token= "Bearer " + response.jsonPath().getString("token");
        System.out.println(token);

    }

}

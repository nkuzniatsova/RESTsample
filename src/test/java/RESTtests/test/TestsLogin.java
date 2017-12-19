package RESTtests.test;

import RESTtests.dataModel.AppUser;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

/**
 * Created by User on 19/02/2017.
 */

public class TestsLogin {

    @Test

/**
 * Login with correct username/password
 */

public void loginCorrectUser() {
    AppUser userApp = new AppUser("user1", "ww1", "");

    String json = RestAssured.given()
            .parameter("id", userApp.getUserName())
            .parameter("password", userApp.getUserPassword())
            .post("http://localhost/api/login").asString();
        JsonElement jsonParsed = new JsonParser().parse(json);
    }

    private String loginAndGetToken() {
        Header header = new Header("Content-Type", "application/json");
        Response response = RestAssured.given().formParam("id", "user1").formParam("password", "password1").header(header).request().post("http://localhost/api/login");
        response.then().contentType(ContentType.JSON).statusCode(200);
        response.then().contentType(ContentType.JSON).body("token", Matchers.notNullValue());
        response.then().contentType(ContentType.JSON).body("token", Matchers.containsString("."));
        //get JsonWebToken from response:
        String token = response.body().jsonPath().get("token");
        String responseHeader = response.headers().getValue("statusCode");
        return token;
    }



}

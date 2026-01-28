import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class UserFlow {

    String userId;
    private static final String API_KEY = "reqres_4b875826679740dabeb5ea4b7d22d524";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }


    @Test(priority = 1)
    public void createUser() {

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .header("x-api-key", API_KEY)
                        .body("{ \"name\": \"Omar\", \"job\": \"tester\" }")
                        .when()
                        .post("/users");

        response.then().statusCode(201);

        userId = response.jsonPath().getString("id");
        System.out.println("created user ID is: " + userId);
        Assert.assertNotNull(userId);
    }

    @Test(priority = 2)
    public void updateUser() {

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .header("x-api-key", API_KEY)
                        .body("{ \"name\": \"Omar\", \"job\": \"Engineer\" }")
                        .when()
                        .put("/users/" + userId);

        response.then().statusCode(200);

        String updatedJob = response.jsonPath().getString("job");
        System.out.println("Job after update is: " + updatedJob);
        Assert.assertEquals(updatedJob, "Engineer");
    }

    @Test(priority = 3)
    public void getUser() {

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .header("x-api-key", API_KEY)
                        .when()
                        .get("/users/" + userId);
        response.then().statusCode(200); // user id is not created in Database so return 404
        System.out.println(response);

    }

    @Test(priority = 4)
    public void deleteUser() {

        given()
                .header("Content-Type", "application/json")
                .header("x-api-key", API_KEY)
                .when()
                .delete("/users/" + userId)
                .then()
                .statusCode(204);

    }

    @Test(priority = 5)
    public void getDeletedUser() {

        given()
                .header("Content-Type", "application/json")
                .header("x-api-key", API_KEY)
                .when()
                .get("/users/" + userId)
                .then()
                .statusCode(404);
    }
}

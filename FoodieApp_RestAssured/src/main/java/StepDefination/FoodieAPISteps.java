package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class FoodieAPISteps {
    private Response response;
    private JSONObject requestPayload;
    private final String baseUrl = "http://localhost:1001";
    private String userId;
    private String restaurantId;
    private String orderId;


    // POST a customer user
    @Given("I have customer user details")
    public void i_have_customer_user_details() {
        RestAssured.baseURI = baseUrl;
        requestPayload = new JSONObject();
        requestPayload.put("id", "user_12");
        requestPayload.put("name", "Customer One");
        requestPayload.put("email", "customer@example.com");
        requestPayload.put("password", "password123");
        requestPayload.put("role", "CUSTOMER");
    }

    @When("I send a POST request to create a user")
    public void i_send_a_post_request_to_create_a_user() {
        response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestPayload.toJSONString())
                .when()
                .post("/api/users");
        if (response.statusCode() == 200) {
            userId = response.jsonPath().getString("id");
        }
    }

    @Then("I validate the user creation status code")
    public void i_validate_the_user_creation_status_code() {
        response.then().statusCode(200);
    }

    @Then("I validate the created user ID")
    public void i_validate_the_created_user_id() {
        response.then().body("id", notNullValue());
    }

    // GET user by ID
    @When("I send a GET request to fetch the user by ID")
    public void i_send_a_get_request_to_fetch_the_user_by_id() {
        response = given()
                .when()
                .get("/api/users/" + "user_12");
    }


    @Then("I validate the user details in the response")
    public void i_validate_the_user_details_in_the_response() {
        response.then()
                .statusCode(200)
                .body("id", equalTo("user_12"))
                .body("name", equalTo("Customer One"));
    }

    //PUT to update user name
    @Given("I have updated user details")
    public void i_have_updated_user_details() {
        requestPayload = new JSONObject();
        requestPayload.put("name", "Updated Customer");
        requestPayload.put("email", "customer@example.com");
        requestPayload.put("password", "password123");
        requestPayload.put("role", "CUSTOMER");
    }

    @When("I send a PUT request to update the user")
    public void i_send_a_put_request_to_update_the_user() {
        response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestPayload.toJSONString())
                .when()
                .put("/api/users/user_12");
    }

    @Then("I validate the updated user name")
    public void i_validate_the_updated_user_name() {
        response.then()
                .statusCode(200)
                .body("name", equalTo("Updated Customer"));
    }

    // POST a restaurant with admin login
    @Given("I have restaurant details")
    public void i_have_restaurant_details() {
        requestPayload = new JSONObject();
        requestPayload.put("id", "rest_12");
        requestPayload.put("name", "Admin Restaurant");
        requestPayload.put("location", "Downtown");
        requestPayload.put("cuisine", "Italian");
    }

    @When("I send a POST request to create a restaurant")
    public void i_send_a_post_request_to_create_a_restaurant() {
        response = given()
                .auth().basic("admin@example.com", "admin123")
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestPayload.toJSONString())
                .when()
                .post("/api/restaurants");
        if (response.statusCode() == 200) {
            restaurantId = response.jsonPath().getString("id");
        }
    }

    @Then("I validate the created restaurant ID")
    public void i_validate_the_created_restaurant_id() {
        response.then()
                .statusCode(200)
                .body("id", notNullValue());
    }

    //post order with customer login
    @Given("I have order details")
    public void i_have_order_details() {
        requestPayload = new JSONObject();
        requestPayload.put("userId", "user_12");
        requestPayload.put("restaurantId", "rest_12");
        requestPayload.put("items", "[{\"itemName\":\"Pizza\",\"quantity\":2}]");
        requestPayload.put("totalPrice", 400);
    }

    @When("I send a POST request to create an order")
    public void i_send_a_post_request_to_create_an_order() {
        response = given()
                .auth().basic("Sweta@example.com", "newd123")
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestPayload.toJSONString())
                .when()
                .post("/api/orders");
        if (response.statusCode() == 200) {
            orderId = response.jsonPath().getString("id");
        }
    }

    @Then("I validate the created order ID")
    public void i_validate_the_created_order_id() {
        response.then()
                .statusCode(200)
                .body("id", notNullValue());
    }

    //GET all orders with admin login
    @When("I send a GET request to fetch all orders")
    public void i_send_a_get_request_to_fetch_all_orders() {
        response = given()
                .auth().basic("admin@example.com", "admin123")
                .when()
                .get("/api/orders");
    }

    @Then("I validate the list of orders in the response")
    public void i_validate_the_list_of_orders_in_the_response() {
        response.then()
                .statusCode(200)
                .body("size()", Matchers.greaterThan(0));
    }

    // DELETE a user with admin login
    @Given("I log in as an admin")
    public void i_log_in_as_an_admin() {
        RestAssured.baseURI = baseUrl;
    }

    @Given("I have the user ID to delete")
    public void i_have_the_user_id_to_delete() {

        userId = "User_05";
    }

    @When("I send a DELETE request")
    public void i_send_a_delete_request() {
        response = given()
                .auth().basic("admin@example.com", "admin123")
                .when()
                .delete("/api/users/delete/" + "User_05");
    }

    @Then("I validate the user deletion status code")
    public void i_validate_the_user_deletion_status_code() {
        response.then().statusCode(200);
    }

}

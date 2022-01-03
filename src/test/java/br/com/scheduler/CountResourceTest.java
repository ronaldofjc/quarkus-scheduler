package br.com.scheduler;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
class CountResourceTest {

    @Test
    void testCountEndpoint() {
        given()
            .when()
            .get("/count")
                .then()
                    .statusCode(200)
                    .body(containsString("count"));
    }

}

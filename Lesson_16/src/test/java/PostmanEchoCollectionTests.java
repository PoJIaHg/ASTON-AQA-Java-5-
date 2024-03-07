import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class PostmanEchoCollectionTests {




    @Test
    public void testGetMethod() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                // Проверяем, что тело ответа содержит нужные значения
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }


    @Test
    public void testPostMethod() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .body("text\n{\"test\": \"value\"}")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("text\n" +
                        "{\"test\": \"value\"}"));
    }

        @Test
        public void testPutMethod() {
            RestAssured.baseURI = "https://postman-echo.com";

            given()
                    .body("text\n{This is expected to be sent back as part of response body.}")
                    .when()
                    .put("/put")
                    .then()
                    .statusCode(200)
                    .body("data", equalTo("text\n" +
                            "{This is expected to be sent back as part of response body.}"));
        }

        @Test
        public void testDeleteMethod() {
            RestAssured.baseURI = "https://postman-echo.com";

            given()
                    .body("text\n{This is expected to be sent back as part of response body.}")
                    .when()
                    .delete("/delete")
                    .then()
                    .statusCode(200)
                    .body("data", equalTo("text\n" +
                            "{This is expected to be sent back as part of response body.}"));
        }

    @Test
    public void testPatchMethod() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .body("text\n{This is expected to be sent back as part of response body.}")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("text\n" +
                        "{This is expected to be sent back as part of response body.}"));
    }
    }


import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APITest {
    @Test
    void deveBuscarPosts(){

        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("$", hasSize(100));


    }

    @Test
    void deveRealizarUmPost(){
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .body("{\"title\": \"Post de Teste\", \"body\": \"Descricao post de teste\", \"userId\": 3}")
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

             }

    @Test
    void deveRealizarUmPut() {
        Post post = new Post("titulo teste", "Descricao post teste", 3);
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .body(post)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200);
    }

    @Test
    void v1deveRealizarUmPut(){
        given()
                    .baseUri("https://jsonplaceholder.typicode.com")
                    .body("{\"title\": \"Post de Teste\", \"body\": \"Descricao post de teste\", \"userId\": 3}")
                    .when()
                    .put("/posts/1")
                    .then()
                    .statusCode(200);

    }

    @Test
    void deveRealizarUmDelete() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200);
    }
}
package tests.F01_board;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.HashMap;

import static endPoints.urls.baseUrl;
import static endPoints.urls.createBoard;
import static io.restassured.RestAssured.given;

public class T01_CreateBoardTest extends BaseTest {
    // Create Fake Data
    static Faker faker = new Faker();

    // Valid Test Case
    public static String testCreateBoard(){
        HashMap<String,String> query_Params = new HashMap<>();
        query_Params.put("name", "yousef");
        query_Params.put("defaultLists","false");

        String boardId;

        boardId =
        given()
                .spec(requestSpecification)
                .queryParams(query_Params)
                .contentType(ContentType.JSON)
        .when()
                .post(createBoard)
        .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().contentType(ContentType.JSON)
                .extract().response().path("id");
        return boardId;
    }
    @Test
    @Description("Valid Test case For Create Board Correctly")
    public void validCreate(){
        testCreateBoard();
    }

    // Invalid Test Cases
    @Test
    @Description("Invalid Test Case Create Board Without Token and Key")
    public static void invalidTestCreateBoardWithoutToken(){
        HashMap<String,String> query_Params = new HashMap<>();
        query_Params.put("name","youseff");
        query_Params.put("defaultLists","false");

            given()
                    .baseUri(baseUrl) // Without Token and Key
                    .queryParams(query_Params)
                    .header("Accept-Encoding","gzip, deflate, br")
                    .contentType(ContentType.JSON)
            .when()
                    .post(createBoard)
            .then()
                    .assertThat().statusCode(401); // unauthorized

    }

    @Test
    @Description("Invalid Test Case Create Board With Blank Name")
    public static void invalidTestCreateBoardWithBlankName(){
        HashMap<String,String> query_Params = new HashMap<>();
        query_Params.put("name","");// blank name
        query_Params.put("defaultLists","false");

            given()
                    .spec(requestSpecification)
                    .queryParams(query_Params)
                    .contentType(ContentType.JSON)
            .when()
                    .post(createBoard)
            .then()
                    .log().all()
                    .assertThat().statusCode(400) // bad request
                    .assertThat().contentType(ContentType.JSON);
    }

    @Test
    @Description("invalid Test Case For Create Board Which Name long than max 16384 characters as documented")
    public static void invalidTestCreateBoardWithLongName(){
        HashMap<String,String> query_Params = new HashMap<>();
        query_Params.put("name", String.valueOf(faker.lorem().characters(16385)));
        query_Params.put("defaultLists","false");

                given()
                        .spec(requestSpecification)
                        .queryParams(query_Params)
                        .contentType(ContentType.JSON)
                .when()
                        .post(createBoard)
                .then()
                        .log().all()
                        .assertThat().statusCode(413); // Payload too long
    }

}

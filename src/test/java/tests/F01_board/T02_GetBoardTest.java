package tests.F01_board;

import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.getUpdateDelete_board;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static tests.F01_board.BoardTest.boardID;

public class T02_GetBoardTest extends BaseTest {
    @Test
    @Description("valid Test case For Get Board")
    public static void testGetBoard(String boardId){
        given()
                .spec(requestSpecification)
                .pathParam("id",boardId)
                .when()
                .get(getUpdateDelete_board)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("id",equalTo(boardId));
    }

    @Test
    @Description("invalid Test case For Get Board With Blank Name")
    public static void invalidTestGetBoardWithoutName(String boardId){
        given()
                .spec(requestSpecification)
                .pathParam("id",boardId)
                .when()
                .get(getUpdateDelete_board)
                .then()
                .log().all()
                .assertThat().statusCode(404); // not found Cuz blank boardId
    }

    @Test
    @Description("invalid Test case For Get Board With Post Method")
    public static void invalidTestGetBoardWithPost(String boardId){
        given()
                .spec(requestSpecification)
                .pathParam("id",boardId)
                .contentType(ContentType.JSON)
                .when()
                .post(getUpdateDelete_board)
                .then()
                .log().all()
                .assertThat().statusCode(404); // Not Found
    }

}
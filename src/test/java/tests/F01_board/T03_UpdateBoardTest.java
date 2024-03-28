package tests.F01_board;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.getUpdateDelete_board;
import static io.restassured.RestAssured.given;
import static tests.F01_board.BoardTest.boardID;

public class T03_UpdateBoardTest extends BaseTest {
    @Test
    public static void testUpdateBoard(){
        given()
                .spec(requestSpecification)
                .pathParam("id",boardID)
                .queryParam("name", "kokoWawa")
                .when()
                .put(getUpdateDelete_board)
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}

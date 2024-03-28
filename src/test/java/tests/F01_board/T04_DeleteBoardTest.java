package tests.F01_board;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.getUpdateDelete_board;
import static io.restassured.RestAssured.given;

public class T04_DeleteBoardTest extends BaseTest {
    @Test
    public static void testDeleteBoard(String boardID){
        given()
                .spec(requestSpecification)
                .pathParam("id",boardID)
                .when()
                .delete(getUpdateDelete_board)
                .then()
                .assertThat().statusCode(200);
    }
}

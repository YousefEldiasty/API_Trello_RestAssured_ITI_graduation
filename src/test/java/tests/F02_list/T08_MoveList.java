package tests.F02_list;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.moveList;
import static io.restassured.RestAssured.given;
import static tests.F02_list.ListTest.board2ID;
import static tests.F02_list.ListTest.listID;

public class T08_MoveList extends BaseTest {
    @Test
    public static void testMoveList(){
        given()
                .spec(requestSpecification)
                .pathParam("list_id",listID)
                .queryParam("newBoard", board2ID)
                .when()
                .put(moveList)
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}

package tests.F02_list;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.createList;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static tests.F01_board.BoardTest.boardID;

public class T05_CreateListTest extends BaseTest {

    @Test
    public static String testCreateList() {
        String listId =
                given()
                    .spec(requestSpecification)
                    .queryParam("name","kokoList")
                    .pathParam("board_1_id", boardID)
                    .contentType(ContentType.JSON)
                .when()
                    .post(createList)
                .then()
                    .log().all()
                    .assertThat().statusCode(200)
                    .assertThat().body("name",equalTo("kokoList"))
                    //.assertThat().body("idBoard",equalTo(boardID))
                    .assertThat().contentType(ContentType.JSON)
                    .extract().path("id");
        return listId;
    }
}

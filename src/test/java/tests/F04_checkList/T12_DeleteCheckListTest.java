package tests.F04_checkList;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.deleteCheckList;
import static io.restassured.RestAssured.given;

public class T12_DeleteCheckListTest extends BaseTest {
    @Test
    public static void testDeleteChecklist(String checklistID){
        given()
                .spec(requestSpecification)
                .pathParam("checkList_id", checklistID)
                .when()
                .delete(deleteCheckList)
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}


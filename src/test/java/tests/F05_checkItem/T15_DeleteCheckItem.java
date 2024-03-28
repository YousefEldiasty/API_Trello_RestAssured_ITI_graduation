package tests.F05_checkItem;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.getDeleteCheckItem;
import static io.restassured.RestAssured.given;
import static tests.F04_checkList.CheckListTest.checkListID;

public class T15_DeleteCheckItem extends BaseTest {
    @Test
    public static void testDeleteCheckItem(String checkItemId){
        given().spec(requestSpecification)
                .pathParams("checkList_id",checkListID,
                "checkItem_id",checkItemId)
                .when()
                .delete(getDeleteCheckItem)
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}

package tests.F05_checkItem;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.getDeleteCheckItem;
import static io.restassured.RestAssured.given;
import static tests.F04_checkList.CheckListTest.checkListID;
import static tests.F05_checkItem.CheckItemTest.checkItemID;

public class T14_GetCheckItemTest extends BaseTest {
    @Test
    public static void testGetCheckItem(){
        given().spec(requestSpecification)
                .pathParams("checkList_id",checkListID,
                        "checkItem_id",checkItemID)
                .when()
                .get(getDeleteCheckItem)
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}

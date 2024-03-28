package tests.F05_checkItem;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.createCheckItem;
import static io.restassured.RestAssured.given;
import static tests.F04_checkList.CheckListTest.checkListID;

public class T13_CreateCheckItem extends BaseTest {
    @Test
    public static String testCreateCheckitem(){
        String checkItemId =
            given().spec(requestSpecification)
                .pathParam("checkList_id",checkListID)
                .queryParam("name","CheckItemName")
                .contentType(ContentType.JSON)
            .when()
                .post(createCheckItem)
            .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().response().path("id");
        return checkItemId;
    }
}

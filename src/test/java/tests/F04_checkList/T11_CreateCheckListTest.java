package tests.F04_checkList;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.createCheckList;
import static io.restassured.RestAssured.given;
import static tests.F03_card.CardTest.cardID;

public class T11_CreateCheckListTest extends BaseTest {
    @Test
    public static String testCreateCheckList(){
        String checkListId =
                given().spec(requestSpecification)
                .queryParam("idCard",cardID)
                .contentType(ContentType.JSON)
                .when()
                .post(createCheckList)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().response().path("id");
                //.assertThat().body("name",equalTo(createPayLoad.getCheckListName()));
        return checkListId;
    }
}

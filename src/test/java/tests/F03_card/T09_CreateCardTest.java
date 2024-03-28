package tests.F03_card;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.createCard;
import static io.restassured.RestAssured.given;

import static tests.F02_list.ListTest.listID;


public class T09_CreateCardTest extends BaseTest {
    @Test
    public static String testCreateCard(){
        String cardId =
                given().spec(requestSpecification)
                        .queryParam("idList", listID)
                        .queryParam("name","card1")
                        .contentType(ContentType.JSON)
                        .when()
                        .post(createCard)
                        .then()
                        .log().all()
                        .assertThat().statusCode(200)
                        .extract().response().path("id");
        //.assertThat().body("name",equalTo(createPayLoad.getListName()));
        return cardId;
    }
}

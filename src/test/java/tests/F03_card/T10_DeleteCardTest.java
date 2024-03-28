package tests.F03_card;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import static endPoints.urls.deleteCard;
import static io.restassured.RestAssured.given;

public class T10_DeleteCardTest extends BaseTest {
    @Test(priority = 4)
    public static void testDeleteCard(String cardId ){
        given().spec(requestSpecification)
                .pathParam("card_id",cardId)
                .when()
                .delete(deleteCard)
                .then()
                .log().all()
                .assertThat().statusCode(200);
        //.assertThat().body("name",equalTo(createPayLoad.getListName()));
    }
}

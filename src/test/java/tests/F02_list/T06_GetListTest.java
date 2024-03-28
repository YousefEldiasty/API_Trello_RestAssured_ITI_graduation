package tests.F02_list;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.getUpdateList;
import static io.restassured.RestAssured.given;
import static tests.F02_list.ListTest.listID;

public class T06_GetListTest extends BaseTest {
    @Test
    public static void testGetListFromBoard(){
        given()
                .spec(requestSpecification)
                .pathParam("list_id",listID)
                .when()
                .get(getUpdateList)
                .then()
                .log().all()
                .assertThat().statusCode(200);
        //.assertThat().body("id",equalTo(listID));
    }
}

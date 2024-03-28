package tests.F02_list;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static endPoints.urls.getUpdateList;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static tests.F02_list.ListTest.listID;

public class T07_UpdateListTest extends BaseTest {
    @Test
    public static void testUpdateList(){
        given()
                .spec(requestSpecification)
                .pathParam("list_id",listID)
                .queryParam("name", "updatedList")
                .when()
                .put(getUpdateList)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name",equalTo("updatedList"));
    }
}

package tests.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static endPoints.urls.*;
import static io.restassured.RestAssured.given;

public class BaseTest {

    public static RequestSpecification requestSpecification;


    @BeforeClass
    public void authorizationMethod(){
        HashMap<String,String> authorization = new HashMap<>();
        authorization.put("token","ATTA06878f4a0b91dd65a5f3d623b8b47fb802fe06b6b5342e5aea5e0127b39495eb0CC12AC1");
        authorization.put("key","1c94aec7db5d68c59ea01ac03ccdc211");
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addQueryParams(authorization)
                .build();
    }
}

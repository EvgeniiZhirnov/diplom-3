package ForUser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class APIcommand {

    public static void createUser(Create create){
        baseURI = "https://stellarburgers.nomoreparties.site";
         given()
                .header("Content-type", "application/json")
                .body(create)
                .when()
                .post("/api/auth/register");
    }

    public static String getToken(Login login){
        baseURI = "https://stellarburgers.nomoreparties.site";
       Response response = given()
                .header("Content-type", "application/json")
                .body(login)
                .when()
                .post("/api/auth/login");
       String userToken = response.jsonPath().getString("accessToken");
       userToken = userToken.substring(7);
       return userToken;
    }

    public static void deleteUser(String userToken){
        baseURI = "https://stellarburgers.nomoreparties.site";
        given()
                .auth().oauth2(userToken)
                .delete("/api/auth/user");
    }
}

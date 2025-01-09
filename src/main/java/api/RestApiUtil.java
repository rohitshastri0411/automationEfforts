package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestApiUtil {

    public static String getApiResponse(String endpoint) {
        Response response = RestAssured.get(endpoint);
        return response.asPrettyString();
    }

    public static int getStatusCode(String endpoint) {
        Response response = RestAssured.get(endpoint);
        return response.getStatusCode();
    }
}


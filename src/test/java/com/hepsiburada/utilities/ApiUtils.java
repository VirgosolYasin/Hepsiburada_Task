package com.hepsiburada.utilities;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    static RequestSpecification requestSpecification;
    static Response response;

    public static RequestSpecification httpRequest() {
        requestSpecification = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON);


        return requestSpecification;
    }


    public static Response requestType(String url, String requestType, Object body) {


        switch (requestType.toUpperCase()) {

            case "GET":
                response = RestAssured.given().headers("accept", "application/json")
                        .and().contentType(ContentType.JSON).get(url);
                break;
            case "POST":
                response = RestAssured.given().accept(ContentType.JSON)
                        .and().contentType(ContentType.JSON).body(body).post(url);
                break;
            case "PATCH":
                response = RestAssured.given().accept(ContentType.JSON)
                        .and().contentType(ContentType.JSON).body(body).patch(url);
                break;
            case "PUT":
                response = RestAssured.given().accept(ContentType.JSON)
                        .and().contentType(ContentType.JSON).body(body).put(url);
                break;
            case "DELETE":
                response= RestAssured.given().header("accept", "application/json").header("api_key","1qa2ws3ed4rfvcxz")
                        .and().contentType(ContentType.JSON).delete(url);

                break;

        }

        return response;
    }

    public static String animalGenerate(String name, String status) {
        return "{   \"id\": 0,   \"category\": {     \"id\": 0,     \"name\": \"string\"   },   \"name\": \"" + name + "\",   \"photoUrls\": [     \"string\"   ],   \"tags\": [     {       \"id\": 0,       \"name\": \"string\"     }   ],   \"status\": \"" + status + "\" }";
    }


    public static String nameGenerator() {
        Faker faker = new Faker();
        return faker.animal().name() + " " + faker.name().firstName();
    }

}

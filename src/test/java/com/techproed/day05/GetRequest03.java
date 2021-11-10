package com.techproed.day05;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest03 {

     /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
accept type'i "application/json" olan GET request'i yolladigimda
gelen response'un
status kodunun 200
ve content type'inin "application/json"
ve firstname'in "Sally"
ve lastname'in "Ericsson"
ve checkin date'in 2018-10-07"
ve checkout date'in 2020-09-30 oldugunu test edin
     */


    @Test

    public void test01(){

        String url = "https://restful-booker.herokuapp.com/booking/7";



        Response response=given().
                accept("application/json").
                when().
                get(url);

        response.prettyPrint();



        System.out.println("Status code :"+ response.getStatusCode());
        System.out.println("Content Type :" +response.getContentType());
        System.out.println("Status Line :" +response.getStatusLine());



        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");
    }
}

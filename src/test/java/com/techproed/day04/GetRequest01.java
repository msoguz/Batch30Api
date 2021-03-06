package com.techproed.day04;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
/*

    https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
    HTTP status kodunun 200
    Content Type'in Json
    Ve Status Line'in HTTP/1.1 200 OK
    Oldugunu test edin

 */
    @Test

        public void test01() {

        // 1- api testi yaparken ilk olarak url(endpoint) belirlenmeli

        String url = "https://restful-booker.herokuapp.com/booking/3";

        //2- beklenen sonuc (expected result )olusturulur.

        // bu case de benden body dogrulamasi istenmedigi icin simdilik beklenen sonuc olusturmuyoruz

        //3- request gonder

        Response response=given().
                accept("application/json").
                when().
                get(url);

        response.prettyPrint();
        //4- actual result olustur

        // response body ile ilgili islem yapmayacagimiz icin simdi olusturmayacagiz

        //5-dogrulama yap (assertion)
        System.out.println("Status code :"+ response.getStatusCode());
        System.out.println("Content Type :" +response.getContentType());
        System.out.println("Status Line :" +response.getStatusLine());

    /*
        Assert.assertEquals(200, response.getStatusCode());

        //expected kismi bize task olark verilen degerdir, actual kismi ise response'dan donen degerdir.
        //status code int deger dondurur.

        Assert.assertEquals("application/json; charset=utf-8", response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusCode());


     */

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");

    }
}

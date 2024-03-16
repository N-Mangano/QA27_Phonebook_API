package com.phonebook.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String token =
            "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoibGF1cmluQGdtYWlsLmNvbSIsImlzcyI6IlJlZ3VsYWl0IiwiZXhwIjoxNzEwODY2MzIxLCJpYXQiOjE3MTAyNjYzMjF9.suZHfyoqTMrDScDpJS7G3mhrsf5c9C0PFFdpq2ItX5Y";
    public static final String AUTH = "Authorization";
    @BeforeMethod
    public void intit() {
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "v1";
    }

}

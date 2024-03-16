package com.phonebook.tests;

import com.phonebook.dto.ContactDto;
import com.phonebook.dto.MessageDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class AddContactRATests extends TestBase{
    @Test
    public void addContactSuccessTest() {
        ContactDto contactDto = ContactDto.builder()
                .name("Laurin")
                .lastName("Kon")
                .email("kon@gm.com")
                .phone("2345678901")
                .address("Paris")
                .description("goalceeper")
                .build();

        MessageDto message = given()
                .header(AUTH, token)
                .body(contactDto)
                .contentType(ContentType.JSON)
                .when()
                .post("contacts")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("message", containsString("Contact was added!"))
                .extract().response().as(MessageDto.class);
        System.out.println(message.getMessage());
        //Contact was added! ID: 0e368ed9-7cde-486e-ba5f-6e0e32e1477f
    }
}

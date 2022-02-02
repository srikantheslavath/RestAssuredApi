package com.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.pageclass.api.constants.EndPoints;
import com.pageclass.api.model.Person;
import com.pageclass.api.utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import org.apache.http.HttpStatus;
import org.testng.Assert;
import java.lang.reflect.Type;
import java.util.List;

public class PersonServiceHelper {


    private static final String BASE_URL = ConfigManager.getInstance().getString("base_url");
    private static final String PORT = ConfigManager.getInstance().getString("port");

    public PersonServiceHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }

    //GET request
    public List<Person> getAllPerson() {
        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get(EndPoints.GET_ALL_PERSON)
                .andReturn();

        Type type = new TypeReference<List<Person>>() {
        }.getType();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK");
        List<Person> personList = response.as(type);
        return personList;
    }

    //POST request
    public Response createPerson() {
        Person person = new Person();
        person.getId(1);
        person.setFirstName("Mahesh");
        person.setLastName("chautapalem");
        person.setAddress("Telecomnagar ,Hyderabad");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(person)
                .port(EndPoints.CREATE_PERSON)
                .andReturn();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "CREATED");

        return response;
    }
// PATCH request

    public Response updatePerson(Integer id) {

        Person person = new Person();
        person.setFirstName("ranjith");
        person.setLastName("kumar");
        person.setAge(35);
        person.setAddress("hyderabad");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .patch(EndPoints.UPDATE_PERSON)
                .andReturn();

        Assert.assertTrue((response.getStatusCode() == HttpStatus.SC_OK));
        return response;
    }

   // DELETE request

    public Response deletePerson(Integer id) {
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id", id)
                .log().all()
                .when().delete(EndPoints.DELETE_PERSON)
                .andReturn();

        Assert.assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
        return response;
    }

}






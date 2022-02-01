package com.pageclass.api.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.pageclass.api.constants.EndPoints;
import com.pageclass.api.model.Person;
import com.pageclass.api.utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.http.ContentEncoding;
import io.restassured.response.Response;


import org.apache.http.HttpStatus;

import java.lang.reflect.Type;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class PersonServiceHelper {


    private static final String BASE_URL = ConfigManager.getInstance().getString("base_url");
    private static final String PORT = ConfigManager.getInstance().getString("port");

    public PersonServiceHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }

    public List<Person> getAllPerson() {
        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get(EndPoints.GET_ALL_PERSON)
                .andReturn();

        Type type = new TypeReference<List<Person>>() {
        }.getType();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK,"OK");
        List<Person> personList = response.as(type);
        return personList;
    }
}






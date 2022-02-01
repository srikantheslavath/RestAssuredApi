package com.pagetests.api;

import com.pageclass.api.helpers.PersonServiceHelper;
import com.pageclass.api.model.Person;
import com.pageclass.api.utils.ConfigManager;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestGETPerson {
    private PersonServiceHelper personServiceHelper;

    @BeforeTest
    public void init(){

    }

    @Test
    public void testGetAllPerson(){
       List<Person> personList =personServiceHelper.getAllPerson();
       assertNotNull(personList,"person list is not empty");
       assertFalse(personList.isEmpty(),"person list is not true");
    }

}

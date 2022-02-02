package com.pagetests.api;

import com.helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestPostPerson {
    // init - PersonServiceHelper
    // Assert create the person and verify it

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();


    }
    @Test
    public void testPOSTCreatePerson(){
       String id = personServiceHelper.createPerson().jsonPath().getString("id");
        System.out.println(id);
        assertNotNull(id, "person id is not null");
    }
}

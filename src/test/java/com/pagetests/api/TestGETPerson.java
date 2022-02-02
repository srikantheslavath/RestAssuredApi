package com.pagetests.api;

import com.helpers.PersonServiceHelper;
import com.pageclass.api.model.Person;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestGETPerson {
    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){

    }

    @Test
    public void testGetAllPerson(){
       List<Person> personList =personServiceHelper.getAllPerson();
       assertNotNull(personList,"person list is not empty");
       assertFalse(personList.isEmpty(),"person list is not true");
    }

}

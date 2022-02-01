package com.pagetests.api;

import com.pageclass.api.helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDELETEPerson {
    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();

    }
    @Test
    public void testDeletePerson(){
        personServiceHelper.deletePerson(3);
    }

}

package test.controller;

import com.errigal.controller.BasePersonController;
import com.errigal.model.Person;
import com.errigal.service.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasePersonControllerTest {

    BasePersonController base;
    @Before
    public void setUp(){
        base = new BasePersonController();
    }

    @Test
    public void personServiceObjTest(){
        Assert.assertEquals(base.personService.getClass(), PersonService.class);
    }

}

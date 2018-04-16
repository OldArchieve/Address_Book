package test.controller;

import com.errigal.controller.CreatePersonController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreatePersonControllerTest {

    CreatePersonController createPersonController;

    @Before
    public void setUp(){
        createPersonController = new CreatePersonController();
    }


    @Test
    public void checkUserNameTest(){
        String firstName = "first";
        String lastName = "last";
        Assert.assertNotEquals(false,createPersonController.checkUserName(firstName,lastName));
    }

    @Test
    public void checkUserNameAnotherTest(){
        String firstName = "";
        String lastName = "";
        Assert.assertEquals(false,createPersonController.checkUserName(firstName,lastName));
    }

}

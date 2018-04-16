package test.model;

import com.errigal.model.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressTest {

    Address address;

    @Before
    public void setUp(){
        String line1 = "line1";
        String line2 = "line2";
        String street = "street";
        String county = "county";
        String pinCode = "pincode";
        address = new Address(line1,line2,street,county,pinCode);
    }


    @Test
    public void classTest(){
        Assert.assertEquals(address.getClass(),Address.class);
    }



    @Test
    public void setAddress1Test(){
        String line = "changed";
        address.setAddressLine1(line);
        Assert.assertEquals(line,address.getAddressLine1());
    }


    @Test
    public void setAddress2Test(){
        String line = "changed";
        address.setAddressLine2(line);
        Assert.assertEquals(line,address.getAddressLine2());
    }

    @Test
    public void setStreetTest(){
        String street = "changed";
        address.setStreet(street);
        Assert.assertEquals(street,address.getStreet());
    }

    @Test
    public void setCountyTest(){
        String county = "changed";
        address.setCounty(county);
        Assert.assertEquals(county,address.getCounty());
    }

    @Test
    public void setPinCode(){
        String pinCode = "pincode";
        address.setPinCode(pinCode);
        Assert.assertEquals(pinCode,address.getPinCode());
    }


}

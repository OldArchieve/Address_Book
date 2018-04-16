package com.errigal.controller;

import com.errigal.model.Address;
import com.errigal.model.Person;
import com.errigal.util.Constant;

import java.util.Iterator;
import java.util.Map;

/**
 * <p> A simple class for displaying users</p>
 */
public class DisplayPersonController extends BasePersonController{

    /****************************************display users***********************/
    //Display the users
    public void displayUsers(Map<Integer, Person> personMap) {
        Iterator<Map.Entry<Integer, Person>> iterator = personMap.entrySet().iterator();
        System.out.println(Constant.STARS);
        System.out.println(Constant.USER_DETAILS);
        System.out.println(Constant.STARS);
        while (iterator.hasNext()) {

            Map.Entry<Integer, Person> pair = (Map.Entry<Integer, Person>) iterator.next();

            System.out.println(Constant.STARS);
            System.out.println(pair.getKey());
            System.out.println(Constant.FIRST_NAME + pair.getValue().getFirstName());
            System.out.println(Constant.LAST_NAME + pair.getValue().getLastName());
            System.out.println(Constant.AGE + pair.getValue().getAge());
            System.out.println(Constant.EMAIL_ADDRESS + pair.getValue().getAge());
            System.out.println(Constant.CONTACT_NUM + pair.getValue().getContactNumber());

            System.out.println(Constant.HOME_ADDRESS_DETAILS);
            for (Address homeAddress : pair.getValue().getHomeAddresses()) {
                System.out.println(homeAddress.getAddressLine1());
                System.out.println(homeAddress.getAddressLine2());
                System.out.println(homeAddress.getStreet());
                System.out.println(homeAddress.getCounty());
                System.out.println(homeAddress.getPinCode());
                System.out.println("\n");
            }
            System.out.println(Constant.OFFICE_ADDRESS_DETAILS);
            for (Address officeAddress : pair.getValue().getOfficeAddresses()) {
                System.out.println(officeAddress.getAddressLine1());
                System.out.println(officeAddress.getAddressLine2());
                System.out.println(officeAddress.getStreet());
                System.out.println(officeAddress.getCounty());
                System.out.println(officeAddress.getPinCode());
                System.out.println("\n");
            }

            System.out.println(Constant.STARS);
        }
    }

    /****************************************display users***********************/

}

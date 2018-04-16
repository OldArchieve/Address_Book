package com.errigal.model;

/**
 * <p>This class is used for storing Address of Person</p>
    @author Srini

 */
public class Address {
    //you can have #, Door no kind of strings
    private String addressLine1;
    private String addressLine2;
    private String street;
    private String county;
    private String pinCode;

    public Address(String addressLine1,String addressLine2,String street,String county,String pinCode){
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.street = street;
        this.county = county;
        this.pinCode = pinCode;
    }


    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    //Auto generated equals and hashcode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (addressLine1 != null ? !addressLine1.equals(address.addressLine1) : address.addressLine1 != null)
            return false;
        if (addressLine2 != null ? !addressLine2.equals(address.addressLine2) : address.addressLine2 != null)
            return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (county != null ? !county.equals(address.county) : address.county != null) return false;
        return pinCode != null ? pinCode.equals(address.pinCode) : address.pinCode == null;
    }

    @Override
    public int hashCode() {
        int result = addressLine1 != null ? addressLine1.hashCode() : 0;
        result = 31 * result + (addressLine2 != null ? addressLine2.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (pinCode != null ? pinCode.hashCode() : 0);
        return result;
    }
}

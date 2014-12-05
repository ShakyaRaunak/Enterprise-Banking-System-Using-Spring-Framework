package com.rkshakyaprojects.banking.model;

/**
 *
 * @author Raunak Shakya
 */
public class CustomerAddress {

    private int addressid;
    private int streetid;
    private String city;
    private String state;
    private String zipcode;

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public int getStreetid() {
        return streetid;
    }

    public void setStreetid(int streetid) {
        this.streetid = streetid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}

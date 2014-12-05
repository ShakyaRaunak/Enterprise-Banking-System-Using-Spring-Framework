package com.rkshakyaprojects.banking.model;

/**
 *
 * @author Raunak Shakya
 */
public class CustomerStreet {

    private int streetid;
    private String street;
    private String streetnumber;
    private String apartmentnumber;

    public int getStreetid() {
        return streetid;
    }

    public void setStreetid(int streetid) {
        this.streetid = streetid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getApartmentnumber() {
        return apartmentnumber;
    }

    public void setApartmentnumber(String apartmentnumber) {
        this.apartmentnumber = apartmentnumber;
    }

}

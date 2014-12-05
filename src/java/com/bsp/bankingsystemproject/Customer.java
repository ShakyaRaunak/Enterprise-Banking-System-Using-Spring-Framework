/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsp.bankingsystemproject;

/**
 *
 * @author Raunak Shakya
 */
public class Customer {
    private int custID;
    private String firstname;
    private String middlename;
    private String lastname;
    private String homecontact;
    private String mobilecontact;
    private String dateofbirth;
    private String dateofjoin;
    private int isactive;
    private String loginname;
    private String loginpass;
    private int addressid;
    private int accountid;

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    
    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpass() {
        return loginpass;
    }

    public void setLoginpass(String loginpass) {
        this.loginpass = loginpass;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHomecontact() {
        return homecontact;
    }

    public void setHomecontact(String homecontact) {
        this.homecontact = homecontact;
    }

    public String getMobilecontact() {
        return mobilecontact;
    }

    public void setMobilecontact(String mobilecontact) {
        this.mobilecontact = mobilecontact;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getDateofjoin() {
        return dateofjoin;
    }

    public void setDateofjoin(String dateofjoin) {
        this.dateofjoin = dateofjoin;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }    
}

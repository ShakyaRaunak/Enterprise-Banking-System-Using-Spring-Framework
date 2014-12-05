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
public class Employee {

    private int empID;
    private String firstname;
    private String middlename;
    private String lastname;
    private String homecontact;
    private String mobilecontact;
    private String dateofjoin;
    private String dateofbirth;
    private String loginname;
    private String loginpass;
    private String address;
    private String department;
    private String post;
    private int isadmin;
    private int isactive;

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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

    public String getDateofjoin() {
        return dateofjoin;
    }

    public void setDateofjoin(String dateofjoin) {
        this.dateofjoin = dateofjoin;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(int isadmin) {
        this.isadmin = isadmin;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }
    
    

}

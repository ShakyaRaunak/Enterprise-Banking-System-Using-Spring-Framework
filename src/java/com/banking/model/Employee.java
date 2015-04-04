/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banking.model;

import com.banking.utils.DepartmentEnum;
import com.banking.utils.EmployeePost;
import com.banking.utils.Status;
import com.banking.utils.UserType;

/**
 *
 * @author Raunak Shakya
 */
public class Employee {

    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String homeContact;
    private String mobileNumber;
    private String dateOfJoin;
    private String dateOfBirth;
    private String username;
    private String password;
    private Integer addressId;
    private DepartmentEnum department;
    private EmployeePost post;
    private UserType userType;
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeContact() {
        return homeContact;
    }

    public void setHomeContact(String homeContact) {
        this.homeContact = homeContact;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(String dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public DepartmentEnum getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEnum department) {
        this.department = department;
    }

    public EmployeePost getPost() {
        return post;
    }

    public void setPost(EmployeePost post) {
        this.post = post;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}

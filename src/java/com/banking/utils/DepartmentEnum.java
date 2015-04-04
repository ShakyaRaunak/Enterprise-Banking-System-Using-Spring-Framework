/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banking.utils;

/**
 *
 * @author raunakshakya
 */
public enum DepartmentEnum {

    CUSTOMER_CARE("Customer Care"),
    INFORMATION_TECHNOLOGY("Information Technology"),
    FINANCE("Finance");

    String name;

    DepartmentEnum(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

}

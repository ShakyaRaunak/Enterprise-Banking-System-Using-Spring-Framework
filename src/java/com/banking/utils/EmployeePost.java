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
public enum EmployeePost {

    CEO("Chief Executive Officer"),
    MANAGER("Manager"),
    IT_OFFICER("IT Officer"),
    RECEPTIONIST("Receptionist");

    String name;

    EmployeePost(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

}

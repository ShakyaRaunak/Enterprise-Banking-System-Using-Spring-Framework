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
public class DatabaseParameters {
    
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String DATABASE_NAME = "BankingSystemDB";
    public static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/" + DATABASE_NAME;
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "niitktm";
    
}

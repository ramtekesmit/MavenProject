/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.webappmaven.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class AnjumanDb {

    private static String DATABASE = AnjumanDb.class.getSimpleName().toLowerCase();
    private static String DBURL = "jdbc:mysql://localhost/" + DATABASE+"?useSSL = false";
    private static final String LOCAL_DB_USER = "root";
    private static final String GLOBAL_DB_USER = "";
    private static final String LOCAL_DB_PASS = "12345";
    private static final String GLOBAL_DB_PASS = "";

    public static Connection connectDb() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBURL, LOCAL_DB_USER, LOCAL_DB_PASS);
            System.out.println("Done");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) throws SQLException {
        connectDb();
    }
}

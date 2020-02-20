/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.webappmaven.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class Test {
     ResultSet rs = null;
     CallableStatement cs = null;
     Connection con = null;
     String query;
    public void selectAll() {
        con = AnjumanDb.connectDb();
        query = "select * from TblStudents";
        try {
            cs = con.prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                System.out.println("Id :" + rs.getInt("Id"));
                System.out.println("Name :" + rs.getString("Name"));
                System.out.println("RollNo :" + rs.getInt("RollNo"));
                System.out.println("Age :" + rs.getInt("Age"));
                System.out.println("Gender :" + rs.getString("Gender"));
                System.out.println("DOB :" + rs.getString("DateOfBirth"));
                System.out.println("PhoneNo :" + rs.getString("PhoneNo"));
                System.out.println("Email :" + rs.getString("EmailId"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void insertRecord() {
        con = AnjumanDb.connectDb();
        query = "insert into TblStudents (Name, RollNo, Age, Gender, DateOfBirth, PhoneNo, EmailId, Address) values (?,?,?,?,?,?,?,?)";
        try {
            cs = con.prepareCall(query);
            cs.setString(1, "Smit Ramteke");
            cs.setString(2, "45");
            cs.setString(3, "20");
            cs.setString(4, "Male");
            cs.setString(5, "26/06/1999");
            cs.setString(6, "9049754101");
            cs.setString(7, "abc@xyz.com");
            cs.setString(8, "Nagpur");
            int row = cs.executeUpdate();
            if (row >= 1) {
                System.out.println("Value Inserted");
            }

        } catch (SQLException e) {
            System.out.println("Unable to insert");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

                System.out.println(e.getMessage());
            }
        }
    }

     public void delete() {
        con = AnjumanDb.connectDb();
        query = "delete from TblStudents where Id = ?";
        try {
            cs = con.prepareCall(query);
            cs.setInt(1,9);
            int row = cs.executeUpdate();
            if (row >= 1) {
                System.out.println("Value Deleted");
            }

        } catch (SQLException e) {
            System.out.println("Unable to delete");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

                System.out.println(e.getMessage());
            }
        }
    }
     public void update() {
        con = AnjumanDb.connectDb();
        query = "update TblStudents set Name = ?,RollNo=? where Id = ?";
        try {
            cs = con.prepareCall(query);
            cs.setString(1,"Ajay Yadav");
            cs.setInt(2,42);
            cs.setInt(3, 8);
            int row = cs.executeUpdate();
            if (row >= 1) {
                System.out.println("Value Updated");
            }

        } catch (SQLException e) {
            System.out.println("Unable to update");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println("Before Update");
        t.selectAll();
        t.update();
        System.out.println("After Update");
        t.selectAll();
      
    }
}

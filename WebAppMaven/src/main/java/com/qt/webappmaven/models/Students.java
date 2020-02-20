/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.webappmaven.models;

import com.qt.webappmaven.beans.TblStudents;
import com.qt.webappmaven.common.AnjumanDb;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Students {

    ResultSet rs = null;
    CallableStatement cs = null;
    Connection con = null;
    String query = null;
    String msg = null;

    public String insert(TblStudents students) {
        con = AnjumanDb.connectDb();
        query = "insert into TblStudents (Name, RollNo, Age, Gender, DateOfBirth, PhoneNo, EmailId, Address) values (?,?,?,?,?,?,?,?)";
        try {
            cs = con.prepareCall(query);
            cs.setString(1, students.getName());
            cs.setInt(2, students.getRollNo());
            cs.setInt(3, students.getAge());
            cs.setString(4, students.getGender());
            cs.setString(5, students.getDob());
            cs.setString(6, students.getPhone());
            cs.setString(7, students.getEmail());
            cs.setString(8, students.getAddress());
            int row = cs.executeUpdate();
            if (row >= 1) {
                msg = "Value Inserted";
            }

        } catch (SQLException e) {
            msg = "Unable to insert because of: " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

                System.out.println(e.getMessage());
            }
        }
        return msg;
    }

    public String delete(TblStudents students) {
        con = AnjumanDb.connectDb();
        query = "delete from TblStudents where Id = ?";
        try {
            cs = con.prepareCall(query);
            cs.setInt(1, students.getId());

            int row = cs.executeUpdate();
            if (row >= 1) {
                msg = "Deleted Successfully";
            }

        } catch (SQLException e) {
            msg = "Unable to delete because of: " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

                System.out.println(e.getMessage());
            }
        }
        return msg;
    }

    public ArrayList<TblStudents> select() {
        con = AnjumanDb.connectDb();
        ArrayList<TblStudents> arrayList = new ArrayList<>();
        try {
            query = "Select * from TblStudents";
            cs = con.prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                arrayList.add(new TblStudents(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("rollNo"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("dateOfBirth"),
                        rs.getString("phoneNo"),
                        rs.getString("emailId"),
                        rs.getString("address")
                )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
        return arrayList;
    }
    
     public TblStudents selectById(int id) {
        con = AnjumanDb.connectDb();
        TblStudents studentValue =null;
        try {
            query = "Select * from TblStudents where id ="+id;
            cs = con.prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                studentValue=new TblStudents(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("rollNo"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("dateOfBirth"),
                        rs.getString("phoneNo"),
                        rs.getString("emailId"),
                        rs.getString("address")
                
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("com.qt.webappmaven.models.Students.selectById()");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
        return studentValue;
    }


    public String update(TblStudents students) {
        con = AnjumanDb.connectDb();
        query = "update TblStudents set Name=?, RollNo=?, Age=?, Gender=?, dateOfBirth=?, PhoneNo=?, EmailId=?, Address=? where Id=?";
        try {
            cs = con.prepareCall(query);
            cs.setString(1, students.getName());
            cs.setInt(2, students.getRollNo());
            cs.setInt(3, students.getAge());
            cs.setString(4, students.getGender());
            cs.setString(5, students.getDob());
            cs.setString(6, students.getPhone());
            cs.setString(7, students.getEmail());
            cs.setString(8, students.getAddress());
            cs.setInt(9, students.getId());
            int row = cs.executeUpdate();
            if (row >= 1) {
                msg = "Updated Successfully";
            }

        } catch (SQLException e) {
            msg = "Unable to update because of: " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

                System.out.println(e.getMessage());
            }
        }
        return msg;
    }

}

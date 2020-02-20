<%-- 
    Document   : Students
    Created on : 15 Feb, 2020, 12:19:31 PM
    Author     : Acer
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.qt.webappmaven.beans.TblStudents"%>
<%@page import="com.qt.webappmaven.models.Students"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Students</h1>
        ${param.message}
        <form action="StudentController" method="get">
            <input type="hidden" name="action" value="insert"/>
            NAME: <input type="text" name="stdName" placeholder="Enter Name"/><br><br>
            ROLL NO: <input required="" type="number" name="stdRollNo" placeholder="Enter Roll No"/><br><br>
            Age: <input required="" type="number" name="stdAge" placeholder="Enter Age"/><br><br>
            Gender: <input required="" type="text" name="stdGender" placeholder="Enter Gender"/><br><br>
            Dob: <input required="" type="date" name="stdDob" placeholder="Enter Date Of Birth"/><br><br>
            Phone: <input required="" type="number" name="stdPhone" placeholder="Enter Phone Number"/><br><br>
            Email: <input required="" type="text" name="stdEmail" placeholder="Enter Email"/><br><br>
            Address: <input required="" type="text" name="stdAddress" placeholder="Enter Address"/><br><br>
            <input type="submit" value="Record Added"/>
            <br><br>
        </form>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>RollNo</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Date Of Birth</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
                <%
                    Students model = new Students();
                    ArrayList<TblStudents> students = model.select();
                    for (TblStudents student : students) {
                %>
                <tr>
                    <td><%=student.getId()%></td>
                    <td><%=student.getName()%></td>
                    <td><%=student.getRollNo()%></td>
                    <td><%=student.getAge()%></td>
                    <td><%=student.getGender()%></td>
                    <td><%=student.getDob()%></td>
                    <td><%=student.getPhone()%></td>
                    <td><%=student.getEmail()%></td>
                    <td><%=student.getAddress()%></td>
                    <td>
                        <a href="StudentController?action=delete&stdId=<%=student.getId()%>">Delete</a>
                        <a href="Update.jsp?stdId=<%=student.getId()%>&stdName=<%=student.getName()%>&stdRollNo=<%=student.getRollNo()%>&stdAge=<%=student.getAge()%>&stdGender=<%=student.getGender()%>&stdDob=<%=student.getDob()%>&stdPhone=<%=student.getPhone()%>&stdEmail=<%=student.getEmail()%>&stdAddress=<%=student.getAddress()%>">Update</a>
                    </td>
                </tr>
                <% }%>
            </table>

    </body>
</html>

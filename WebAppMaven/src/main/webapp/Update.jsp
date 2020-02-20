<%-- 
    Document   : Update
    Created on : 19 Feb, 2020, 10:40:28 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Update</h1>
        <form method="get" action="StudentController">
            <input type="hidden" name="action" value="update"/>
            ID: <input type="hidden" name="stdId" value="${param.stdId}"/>
            NAME: <input required="" type="text" value="<%=request.getParameter("stdName")%>" name="stdName"/><br><br>
            ROLL NO: <input required="" type="number" value="<%=request.getParameter("stdRollNo")%>" name="stdRollNo"/><br><br>
            Age: <input required="" type="number" value="<%=request.getParameter("stdAge")%>" name="stdAge"/><br><br>
            Gender: <input required="" type="text" value="<%=request.getParameter("stdGender")%>" name="stdGender"/><br><br>
            Old Dob is :<input type="text" readonly="" value="<%=request.getParameter("stdDob")%>" name="oldDob"/><br><br>
            Update Dob: <input type="date" name="newDob"/><br><br>
            Phone: <input required="" type="number" value="<%=request.getParameter("stdPhone")%>" name="stdPhone"/><br><br>
            Email: <input required="" type="text" value="<%=request.getParameter("stdEmail")%>" name="stdEmail"/><br><br>
            Address: <input required="" type="text" value="<%=request.getParameter("stdAddress")%>" name="stdAddress"/><br><br>
            <input type="submit" value="Updated"/>
            <br><br>
        </form>
    </body>
</html>

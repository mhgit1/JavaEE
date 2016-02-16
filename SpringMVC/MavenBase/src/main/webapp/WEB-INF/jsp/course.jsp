<%-- 
    Document   : course
    Created on : Feb 16, 2016, 2:42:39 PM
    Author     : Ohjelmistokehitys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css" />
        <title>Course Info</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <h2>Add course information</h2>
            <div class="row">
                <div class="col-md-4">
                    <form:form action="/admin/teacher/course" method="POST" modelAttribute="course">
                        <form:label path="">Name</form:label><br/>             
                        <form:input cssClass="form-control" path="CName"></form:input><br/> 
                        <form:label path="">Grade</form:label><br/>            
                        <form:input cssClass="form-control" path="grade"></form:input><br/> 
                        <form:label path="">Course Information</form:label><br/>            
                        <form:input cssClass="form-control" path="CInfo"></form:input><br/> 
                        <input class="btn btn-primary" type="submit" value="Save Course">
                    </form:form>
                    <p>${save_info}</p>
                </div>
                <div class="col-md-offset-1 col-md-7">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Grade</th>
                                <th>Course Information</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="course" items="${courses}">
                                <tr>
                                    <td>${course.getCName()}</td>
                                    <td>${course.getGrade()}</td>
                                    <td>${course.getCInfo()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

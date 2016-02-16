<%-- 
    Document   : second
    Created on : Feb 9, 2016, 1:04:36 PM
    Author     : Ohjelmistokehitys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!--prefix voi olla mikä tahansa.-->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css" />
        <title>Teacher</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <h2>Add new teacher</h2>
            <div class="row">
                <div class="col-md-4">
                    <form:form action="/admin/teacher" method="POST" modelAttribute="teacher">     <!--modelAttributen voi nimetä miten haluaa. Täytyy olla sama kuin controllerin @modelAttribute-->
                        <form:label path="">Name</form:label><br/>            
                        <form:input cssClass="form-control" path="TName"></form:input><br/> 
                        <form:label path="">Email</form:label><br/>            
                        <form:input cssClass="form-control" path="email"></form:input><br/> 
                        <form:label path="">Phone</form:label><br/>            
                        <form:input cssClass="form-control" path="phone"></form:input><br/> 
                        <form:label path="">Subject</form:label><br/>            
                        <form:input cssClass="form-control" path="TSubject"></form:input><br/>  
                        <input class="btn btn-primary" type="submit" value="Save Teacher">
                    </form:form>
                    <p>${save_info}</p>
                </div>
                <div class="col-md-offset-1 col-md-7">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Subject</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="teach" items="${teachers}">
                                <tr>
                                    <td>${teach.getTName()}</td>
                                    <td>${teach.getEmail()}</td>
                                    <td>${teach.getPhone()}</td>
                                    <td>${teach.getTSubject()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>       
    </body>
</html>

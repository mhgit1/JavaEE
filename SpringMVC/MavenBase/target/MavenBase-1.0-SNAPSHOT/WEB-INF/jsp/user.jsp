<%-- 
    Document   : user
    Created on : Feb 17, 2016, 12:47:48 PM
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
        <title>User</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <h2>Add new student</h2>
            <div class="row">
                <div class="col-md-4">
                    <form:form action="/admin/user" method="POST" modelAttribute="user">
                        <form:label path="">Username</form:label><br/>             
                        <form:input cssClass="form-control" path="username"></form:input><br/> 
                        <form:label path="">Password</form:label><br/>            
                        <form:input cssClass="form-control" path="password"></form:input><br/>
                        <form:label path="">Enabled</form:label><br/> 
                        <form:input cssClass="form-control" path="enabled"></form:input><br/> 
                        <form:label path="">Role</form:label><br/>            
                        <form:input cssClass="form-control" path="userRoleses"></form:input><br/>  
                        <input class="btn btn-primary" type="submit" value="Save User">
                    </form:form>
                    <p>${save_info}</p>
                </div>
                <div class="col-md-offset-1 col-md-7">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Enabled</th>
                                <th>Role</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.getUsername()}</td>
                                    <td>${user.getPassword()}</td>
                                    <td>${user.getEnabled()}</td>
                                    <td>${user.getUserRoleses()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

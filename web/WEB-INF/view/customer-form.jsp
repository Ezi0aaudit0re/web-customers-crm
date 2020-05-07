<%--
  Created by IntelliJ IDEA.
  User: amannagpal
  Date: 2020-05-07
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>

    <div id="wrapper">
        <div id="header">
            CRM - Customer Relation Manager
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>

        <form:form action="saveCustomer" modelAttribute="customer" method="post">


            <%--link id to orignal Customer--%>
            <form:hidden path="id" />
            <table>
                <tbody>
                    <tr>
                        <td><label>First Name: </label></td>
                        <td><form:input path="firstName" /></td>

                    </tr>

                    <tr>
                        <td><label>Last Name: </label></td>
                        <td><form:input path="lastName" /></td>
                    </tr>
                    <tr>
                        <td><label>Email: </label></td>
                        <td><form:input path="email" /></td>
                    </tr>

                    <tr>
                        <td><label for=""></label></td>
                        <td><input type="submit" value="Save" class="save" /></td>
                    </tr>
                </tbody>
            </table>

        </form:form>
    </div>
    <p><a href="${pageContext.request.contextPath}/customer/list">Home</a></p>


</body>
</html>

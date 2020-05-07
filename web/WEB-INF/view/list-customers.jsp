<%--
  Created by IntelliJ IDEA.
  User: amannagpal
  Date: 2020-05-05
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Customers List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>


    <div id="wrapper">

        <div id="header">
            <h1>Customers List </h1>
        </div>

        <div id="container">

            <div id="content">

                <%--Go to the add customer form--%>
                <input  class="add-button" type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;">

                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="tempCustomer" items="${customers}" >


                        <%--Create URL--%>
                        <%--update url--%>
                        <c:url var="updateLink" value="/customer/showFormForUpdate">
                            <c:param name="customerId" value="${tempCustomer.id}" />
                        </c:url>

                        <%--delete url--%>
                        <c:url var="deleteLink" value="/customer/delete">
                            <c:param name="customerId" value="${tempCustomer.id}" />
                        </c:url>

                        <tr>
                            <td> ${tempCustomer.firstName}</td>
                            <td> ${tempCustomer.lastName}</td>
                            <td> ${tempCustomer.email}</td>
                            <td>
                                <a href="${updateLink}">Update</a>
                                | <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete ?'))) return false">Delete</a>
                            </td>

                        </tr>



                    </c:forEach>
                </table>



            </div>



        </div>

    </div>




</body>
</html>

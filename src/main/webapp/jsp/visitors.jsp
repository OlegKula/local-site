<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 09.07.2020
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Visitors</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${visitors}" var="user">
                <li>
                        ${user.firstName}
                        ${user.secondName}
                    <br>${user.email}
                    <br>-------------------
                </li>
            </c:forEach>
        </ul>


    </body>
</html>

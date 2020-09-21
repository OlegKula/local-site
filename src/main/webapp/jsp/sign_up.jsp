<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 03.07.2020
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Sign up</title>


        <link rel="stylesheet" href="/css/theme/${cookie.color.value}.css" type="text/css"/>

        <meta charset="UTF-8">
    </head>
    <body>
        Створення облікового запису:
        <form method="post" action="/signUp">
            <label for="firstName">Ваше Ім'я:</label><br />
            <input type="text" name="firstName" id="firstName" placeholder="Ім'я" />
            <br /><br />
            <label for="secondName">Ваше Прізвище:</label><br />
            <input type="text" name="secondName" id="secondName" placeholder="Прізвище" />
            <br /><br />
            <label for="email">Ваша Пошта:</label><br />
            <input type="email" name="email" id="email" placeholder="Пошта" />
            <br /><br />
            <label for="secondName">Введіть пароль:</label><br />
            <input type="password" name="password" id="password" placeholder="Пароль" />
            <br /><br />
            <input type="submit" value="Створити" />
        </form>

        <div><p>${requestScope.message}</p></div>

    </body>
</html>

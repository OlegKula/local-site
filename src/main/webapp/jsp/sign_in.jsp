<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 09.07.2020
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Sign in</title>

        <link rel="stylesheet" href="/css/style.css" type="text/css"/>
        <link rel="stylesheet" href="/css/theme/${cookie.color.value}.css" type="text/css"/>
    </head>
    <body>
        Для Входу до системи використовуйте Вашу поштову адресу та пароль:
        <form method="post" action="signIn">
            <label for="email">Електронна пошта:</label><br />
            <input type="email" id="email" name="email" placeholder="Введіть email"/>
            <br /><br />
            <label for="password">Пароль:</label><br />
            <input type="password" id="password" name="password" placeholder="Введіть пароль"/>
            <br /><br />
            <input type="submit" value="Вхід" />
        </form>
        <a href="signUp">Зареєструватися</a>

    </body>
</html>

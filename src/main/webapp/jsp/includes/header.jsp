<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 09.07.2020
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="/css/style.css" type="text/css"/>
        <link rel="stylesheet" href="/css/theme/${cookie.color.value}.css" type="text/css"/>

        <script>
            function hide_button(){
                document.getElementById('color_submit').style.display = "none";
            }

            function submit() {
                document.getElementById('colorChange').submit();
            }


        </script>
    </head>
    <body  onload="hide_button()">
        <header>
            <nav>
                <ul id="topmenu">
                    <li>
                        <a href="main">Головна</a>
                    </li>

                    <li>
                        <a href="communication">Спілкування</a>
                    </li>

                    <li>
                        <a href="visitors">Користувачі</a>
                    </li>

                    <li>
                        <a href="signOut">Вийти</a>
                    </li>

                </ul>
            </nav>

            <form method="post" action="/color" id="colorChange">
                <select name="color" title="Color" onchange="submit()">
                    <option>Background color:</option>
                    <option value="red">Red Rum</option>
                    <option value="dark">Dark</option>
                    <option value="blue">Blizzard Blue</option>
                    <option value="yellow">Yellow (Crayola)</option>
                    <option value="white">Default White</option>
                </select>
                <input type="submit" id="color_submit" value="OK"/>


            </form>
        </header>
    </body>
</html>

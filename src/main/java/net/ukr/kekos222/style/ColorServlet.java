package net.ukr.kekos222.style;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/color")
public class ColorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");


        Cookie colorCookie = new Cookie("color", color);


        colorCookie.setMaxAge(60 * 60 * 24 * 365 * 10);


        resp.addCookie(colorCookie);


        resp.sendRedirect(req.getHeader("referer"));

    }
}
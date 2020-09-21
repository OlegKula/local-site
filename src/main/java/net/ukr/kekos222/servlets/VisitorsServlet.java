package net.ukr.kekos222.servlets;

import net.ukr.kekos222.model.User;
import net.ukr.kekos222.repo.UserRepo;
import net.ukr.kekos222.repo.UserRepoDB;
import net.ukr.kekos222.repo.UserRepoInMemory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/visitors")
public class VisitorsServlet extends HttpServlet {

    private UserRepo users;

    @Override
    public void init() throws ServletException {
        this.users = new UserRepoDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> visitors = users.findAll();
        req.setAttribute("visitors", visitors);
        req.getServletContext().getRequestDispatcher("/jsp/visitors.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

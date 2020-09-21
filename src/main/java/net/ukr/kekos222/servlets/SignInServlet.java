package net.ukr.kekos222.servlets;

import net.ukr.kekos222.repo.UserRepo;
import net.ukr.kekos222.repo.UserRepoDB;
import net.ukr.kekos222.repo.UserRepoInMemory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private UserRepo users;

    @Override
    public void init() throws ServletException {
        this.users = new UserRepoDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/sign_in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (users.isExist(email, password)){
            HttpSession session = req.getSession();
            session.setAttribute("user", email);
            resp.sendRedirect("/main");
        } else {
            resp.sendRedirect("/signIn");
        }
    }
}

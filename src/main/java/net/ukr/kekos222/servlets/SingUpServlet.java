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

@WebServlet("/signUp")
public class SingUpServlet extends HttpServlet {
    private UserRepo users;

    @Override
    public void init() throws ServletException {
        this.users = new UserRepoDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/sign_up.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if(users.isExist(email,password)){
            //logic
            req.setAttribute("message", "Користувач з такою поштовою адресою вже існує." +
                    "Введіть іншу адресу.");
            req.getServletContext().getRequestDispatcher("/jsp/sign_up.jsp").forward(req,resp);
        } else {
            users.save(new User(firstName,secondName,email,password));
            resp.sendRedirect("signIn");

        }
    }
}

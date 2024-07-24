package by.tms.l28_29.servlet;

import by.tms.l28_29.model.User;
import by.tms.l28_29.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/login", name = "LoginServlet") // localhost:8080/login
public class LoginServlet extends HttpServlet {
    UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        req.setAttribute("username", username);

        getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<User> login = userService.login(username, password);
        if (login.isPresent()) {
            User o = login.get();
            req.getSession().setAttribute("user", o);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("message", "User not found");
            getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
        }
    }
}
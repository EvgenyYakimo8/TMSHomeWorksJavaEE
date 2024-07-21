package by.tms.l28_29;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/") // localhost:8080?name=Colos
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        boolean flag = Boolean.parseBoolean(req.getParameter("flag"));

        List<String> list = new ArrayList<>();
        list.add(name);
        list.add(name + name);
        list.add(name + name + name);
        list.add(name + name + name + name);

        req.setAttribute("flag", flag);
        req.setAttribute("list", list);
        req.setAttribute("name", name);

        getServletContext().getRequestDispatcher("/pages/home.jsp").forward(req, resp);
    }
}
package by.tms.lesson24_25.servlet;

import by.tms.lesson24_25.model.Operation;
import by.tms.lesson24_25.service.OperationService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/operation") // localhost:8080/operation?num1=2&num2=2&type=sum
public class OperationServlet extends HttpServlet {
    private final OperationService operationService = new OperationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String type = req.getParameter("type");

        resp.setContentType("application/json");

        Operation operation = new Operation(num1, num2, type);
        Operation execute = operationService.executeOperation(operation);

        Gson gson = new Gson();
        String json = gson.toJson(execute);
        resp.getWriter().println(json);
    }
}
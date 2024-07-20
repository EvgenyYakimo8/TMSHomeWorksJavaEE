package by.tms.l24_25.servlet;

import by.tms.l24_25.model.Operation;
import by.tms.l24_25.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/history") //localhost:8080/history
public class HistoryOperationServlet extends HttpServlet {
    final private OperationService operationService = new OperationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Operation> operations = operationService.getAllOperations();

        resp.setContentType("text/html");
        resp.getWriter().println(operations.toString());
    }
}

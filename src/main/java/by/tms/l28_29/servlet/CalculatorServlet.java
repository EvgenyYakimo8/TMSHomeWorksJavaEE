package by.tms.l28_29.servlet;

import by.tms.l28_29.model.Operation;
import by.tms.l28_29.service.OperationService;
import by.tms.l28_29.storage.InMemoryCalculatorStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/calc", name = "CalculatorServlet") // localhost:8080/calc
public class CalculatorServlet extends HomeServlet {
    OperationService operationService = new OperationService();
    InMemoryCalculatorStorage inMemoryCalculatorStorage = InMemoryCalculatorStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String type = req.getParameter("type");

        Operation operation = Operation.builder()
                .num1(num1)
                .num2(num2)
                .type(type)
                .build();

        Operation execute = operationService.executeOperation(operation);
        req.setAttribute("result", execute.getResult());
        req.setAttribute("operationsHistory", inMemoryCalculatorStorage.getCalculatorHistory());
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}
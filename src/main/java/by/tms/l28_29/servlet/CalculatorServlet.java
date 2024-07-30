package by.tms.l28_29.servlet;

import by.tms.l28_29.service.OperationService;
import by.tms.l28_29.model.operations.DivOperation;
import by.tms.l28_29.model.operations.MulOperation;
import by.tms.l28_29.model.operations.SubOperation;
import by.tms.l28_29.model.operations.SumOperation;
import by.tms.l28_29.storage.InMemoryCalculatorStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/calc", name = "CalculatorServlet") // localhost:8080/calc
public class CalculatorServlet extends HomeServlet {
    OperationService operationService = OperationService.getInstance();
    InMemoryCalculatorStorage inMemoryCalculatorStorage = InMemoryCalculatorStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        by.tms.l28_29.model.operations.Operation operation = switch (req.getParameter("type")){
            case "SUM","sum" -> new SumOperation(Double.parseDouble(req.getParameter("num1")), Double.parseDouble(req.getParameter("num2")), req.getParameter("type"));
            case "SUB","sub" -> new SubOperation(Double.parseDouble(req.getParameter("num1")), Double.parseDouble(req.getParameter("num2")), req.getParameter("type"));
            case "MUL","mul" -> new MulOperation(Double.parseDouble(req.getParameter("num1")), Double.parseDouble(req.getParameter("num2")), req.getParameter("type"));
            case "DIV","div" -> new DivOperation(Double.parseDouble(req.getParameter("num1")), Double.parseDouble(req.getParameter("num2")), req.getParameter("type"));
            default -> throw new IllegalStateException("Unexpected value: " + (req.getParameter("type")));
        };

        double result = operationService.process(operation);
        req.setAttribute("result", result);
        req.setAttribute("operationsHistory", inMemoryCalculatorStorage.getCalculatorHistory());
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}
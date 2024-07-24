package by.tms.l28_29.service;

import by.tms.l28_29.model.Operation;
import by.tms.l28_29.storage.InMemoryCalculatorStorage;
import by.tms.l28_29.storage.InMemoryUserStorage;

public class OperationService {
    private final InMemoryCalculatorStorage inMemoryCalculatorStorage = InMemoryCalculatorStorage.getInstance();

    public Operation executeOperation(Operation operation) {
        switch (operation.getType()) {
            case "SUM", "sum":
                operation.setResult(operation.getNum1() + operation.getNum2());
                inMemoryCalculatorStorage.safeCalculatorHistory(operation);
                return operation;
            case "SUB", "sub":
                operation.setResult(operation.getNum1() - operation.getNum2());
                inMemoryCalculatorStorage.safeCalculatorHistory(operation);
                return operation;
            case "MUL", "mul":
                operation.setResult(operation.getNum1() * operation.getNum2());
                inMemoryCalculatorStorage.safeCalculatorHistory(operation);
                return operation;
            case "DIV", "div":
                operation.setResult(operation.getNum1() / operation.getNum2());
                inMemoryCalculatorStorage.safeCalculatorHistory(operation);
                return operation;
        }
        throw new IllegalArgumentException("Operation type not supported");
    }
}
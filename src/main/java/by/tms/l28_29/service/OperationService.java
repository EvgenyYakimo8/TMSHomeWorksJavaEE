package by.tms.l28_29.service;

import by.tms.l28_29.model.Operation;

public class OperationService {

    public Operation executeOperation(Operation operation) {
        switch (operation.getType()) {
            case "SUM", "sum":
                operation.setResult(operation.getNum1() + operation.getNum2());
                return operation;
            case "SUB", "sub":
                operation.setResult(operation.getNum1() - operation.getNum2());
                return operation;
            case "MUL", "mul":
                operation.setResult(operation.getNum1() * operation.getNum2());
                return operation;
            case "DIV", "div":
                operation.setResult(operation.getNum1() / operation.getNum2());
                return operation;
        }
        throw new IllegalArgumentException("Operation type not supported");
    }
}
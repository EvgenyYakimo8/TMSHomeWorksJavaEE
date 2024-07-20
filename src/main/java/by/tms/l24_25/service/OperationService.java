package by.tms.l24_25.service;

import by.tms.l24_25.model.Operation;
import by.tms.l24_25.storage.JsonFileStorage;
import by.tms.l24_25.storage.OperationStorage;

import java.util.List;

public class OperationService{
    private final OperationStorage operationStorage = new JsonFileStorage();

    public Operation executeOperation(Operation operation) {
        switch (operation.getType()) {
            case "SUM", "sum":
                operation.setResult(operation.getNum1() + operation.getNum2());
                operationStorage.safe(operation);
                return operation;
            case "SUB", "sub":
                operation.setResult(operation.getNum1() - operation.getNum2());
                operationStorage.safe(operation);
                return operation;
            case "MUL", "mul":
                operation.setResult(operation.getNum1() * operation.getNum2());
                operationStorage.safe(operation);
                return operation;
            case "DIV", "div":
                operation.setResult(operation.getNum1() / operation.getNum2());
                operationStorage.safe(operation);
                return operation;
        }
        throw new IllegalArgumentException("Operation type not supported");
    }
    public List<Operation> getAllOperations() {
        return operationStorage.findAll();
    }
}

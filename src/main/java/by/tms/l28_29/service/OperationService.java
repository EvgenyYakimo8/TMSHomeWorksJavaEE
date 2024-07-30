package by.tms.l28_29.service;

import by.tms.l28_29.storage.InMemoryCalculatorStorage;

public class OperationService {

    private final InMemoryCalculatorStorage inMemoryCalculatorStorage = InMemoryCalculatorStorage.getInstance();
    private static OperationService instance;

    private OperationService() {}

    public static OperationService getInstance() {
        if (instance == null) {
            instance = new OperationService();
        }
        return instance;
    }

    public double process(by.tms.l28_29.model.operations.Operation operation) {
        operation.execute();
        inMemoryCalculatorStorage.saveCalculatorHistory(operation);
        return operation.getResult();
    }
}
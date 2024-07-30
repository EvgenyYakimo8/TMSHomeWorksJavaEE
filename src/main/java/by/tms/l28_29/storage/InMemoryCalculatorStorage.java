package by.tms.l28_29.storage;

import by.tms.l28_29.model.operations.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton
 * */

public class InMemoryCalculatorStorage {
    private static InMemoryCalculatorStorage instance;

    private final List<by.tms.l28_29.model.operations.Operation> calculatorHistory = new ArrayList<>();

    private InMemoryCalculatorStorage() {}

    public static InMemoryCalculatorStorage getInstance() {
        if (instance == null) {
            instance = new InMemoryCalculatorStorage();
        }
        return instance;
    }

    public void saveCalculatorHistory(by.tms.l28_29.model.operations.Operation operation) {
        calculatorHistory.add(operation);
    }

    public List<Operation> getCalculatorHistory() {
        return calculatorHistory;
    }
}
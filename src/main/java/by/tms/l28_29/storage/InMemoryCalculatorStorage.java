package by.tms.l28_29.storage;

import by.tms.l28_29.model.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCalculatorStorage {
    private static InMemoryCalculatorStorage instance;

    private final List<Operation> calculatorHistory = new ArrayList<>();

    private InMemoryCalculatorStorage() {}

    public static InMemoryCalculatorStorage getInstance() {
        if (instance == null) {
            instance = new InMemoryCalculatorStorage();
        }
        return instance;
    }

    public void safeCalculatorHistory(Operation operation) {
        calculatorHistory.add(operation);
    }

    public List<Operation> getCalculatorHistory() {
        return calculatorHistory;
    }
}
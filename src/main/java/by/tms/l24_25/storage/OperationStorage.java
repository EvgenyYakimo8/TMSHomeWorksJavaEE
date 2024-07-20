package by.tms.l24_25.storage;

import by.tms.l24_25.model.Operation;

import java.util.List;

public interface OperationStorage {
    void safe(Operation operation);
    List<Operation> findAll();
}

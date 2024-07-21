package by.tms.l24_25.storage;

import by.tms.l24_25.model.Operation;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonFileStorage implements OperationStorage {
    final private Gson gson = new Gson();
    final private File HISTORY_OPERATION = new File("D:\\JAVA\\projects_java\\TMSHomeWorksJavaEE\\TMSHomeWorksJavaEE\\src\\main\\resources\\history.json");

    @Override
    public void safe(Operation operation) {
        List<Operation> list = historyReader();

        if (list == null || list.isEmpty()) {
            list = new ArrayList<>();
            list.add(operation);
        } else {
            list.add(operation);
        }

        try (FileWriter fileWriter = new FileWriter(HISTORY_OPERATION)) {
            gson.toJson(list, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Operation> findAll() {
        return historyReader();
    }

    // ниже служебные приватные методы
    private List<Operation> historyReader() {
        List<Operation> list;
        try (FileReader fileReader = new FileReader(HISTORY_OPERATION)) {
            TypeToken<ArrayList<Operation>> listType = new TypeToken<>() {};
            list = gson.fromJson(fileReader, listType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
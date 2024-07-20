package by.tms.l24_25.storage;

import by.tms.l24_25.model.Operation;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonFileStorage implements OperationStorage {
    final private Gson gson = new Gson();
    final private File HISTORY_OPERATION = new File("D:\\JAVA\\projects_java\\TMSHomeWorksJavaEE\\TMSHomeWorksJavaEE\\src\\main\\java\\by\\tms\\l24_25\\storage\\history.json");

    @Override
    public void safe(Operation operation) {
        List<Operation> list = new ArrayList<>();

        try (FileReader fileReader = new FileReader(HISTORY_OPERATION)) {
            if (HISTORY_OPERATION.length()<1) {
                list.add(operation);
            } else { // todo протестить, если файл окажется пустым и не пустым
                Type listType = new TypeToken<List<Operation>>() {
                }.getType();
                list.add(gson.fromJson(fileReader, listType));
                list.add(operation);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String json = gson.toJson(list);

        try (FileWriter fileWriter = new FileWriter(HISTORY_OPERATION)) {
            gson.toJson(json, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Operation> findAll() {
        List<Operation> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(HISTORY_OPERATION))) {
            Type listType = new TypeToken<List<Operation>>() {
            }.getType();
            list.add(gson.fromJson(bufferedReader, listType));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
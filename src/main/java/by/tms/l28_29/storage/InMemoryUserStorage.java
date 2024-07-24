package by.tms.l28_29.storage;

import by.tms.l28_29.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryUserStorage {
    private static InMemoryUserStorage instance;

    private final List<User> users = new ArrayList<User>();

    private InMemoryUserStorage() {}

    public static InMemoryUserStorage getInstance() {
        if (instance == null) {
            instance = new InMemoryUserStorage();
        }
        return instance;
    }

    public void save(User user) {
        users.add(user);
    }

    public Optional<User> findByUsername(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();//users.stream().filter(u -> u.getUserName().equals(username)).findFirst();
    }
}

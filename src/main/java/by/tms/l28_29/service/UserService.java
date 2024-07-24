package by.tms.l28_29.service;

import by.tms.l28_29.model.User;
import by.tms.l28_29.storage.InMemoryUserStorage;

import java.util.Optional;
/**
 * Singleton
 * */
public class UserService {
    private static UserService instance;

    private final InMemoryUserStorage inMemoryUserStorage = InMemoryUserStorage.getInstance();

    private UserService() {}

    public void registration(User user){
        //encrypt password
        inMemoryUserStorage.save(user);
    }

    public static UserService getInstance() {
        if(instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public Optional<User> login(String username, String password){
        Optional<User> byUsername = inMemoryUserStorage.findByUsername(username);
        if (byUsername.isPresent()){
            User user = byUsername.get();
            if (user.getPassword().equals(password)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}

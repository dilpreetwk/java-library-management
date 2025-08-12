package org.example.java.libraray.management.repository;

import org.example.java.libraray.management.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private final Map<Long, User> userMap = new HashMap<>();

    public User findById(Long id) {
        return userMap.get(id);
    }

    public User add(User user) {
        if (user.getId() == null) {
            throw new RuntimeException("User ID cannot be null");
        }

        userMap.put(user.getId(), user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
}

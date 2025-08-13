package org.example.java.libraray.management.repository;

import org.example.java.libraray.management.exception.GlobalException;
import org.example.java.libraray.management.model.User;
import org.example.java.libraray.management.util.UserUtil;

import java.util.*;

public class UserRepository {

    private final Map<Long, User> userMap = new HashMap<>();

    public UserRepository() {
        userMap.putAll(UserUtil.defaultSeedUserMap());
    }

    public User findById(Long id) {
        return Optional.ofNullable(userMap.get(id))
                .orElseThrow(() -> new GlobalException("User not found with id: " + id));
    }

    public User add(User user) {
        if (user.getId() == null) {
            throw new GlobalException("User ID cannot be null");
        }

        userMap.put(user.getId(), user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
}

package org.example.java.libraray.management.infra.repository;

import org.example.java.libraray.management.core.exception.GlobalException;
import org.example.java.libraray.management.core.model.User;
import org.example.java.libraray.management.util.UserUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository {

    private final Map<Long, User> userMap = new HashMap<>();
    private final AtomicLong idGenerator;

    public UserRepository() {
        userMap.putAll(UserUtil.defaultSeedUserMap());
        idGenerator = new AtomicLong(userMap.size() + 1);
    }

    public User findById(Long id) {
        return Optional.ofNullable(userMap.get(id))
                .orElseThrow(() -> new GlobalException("User not found with id: " + id));
    }

    public User add(User user) {
        user.setId(idGenerator.getAndIncrement());
        userMap.put(user.getId(), user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
}

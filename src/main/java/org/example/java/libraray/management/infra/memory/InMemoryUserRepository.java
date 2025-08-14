package org.example.java.libraray.management.infra.memory;

import org.example.java.libraray.management.core.exception.GlobalException;
import org.example.java.libraray.management.core.model.User;
import org.example.java.libraray.management.core.repository.UserRepository;
import org.example.java.libraray.management.util.UserUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserRepository implements UserRepository {

    private final Map<Long, User> userMap = new HashMap<>();
    private final AtomicLong idGenerator;

    public InMemoryUserRepository() {
        userMap.putAll(UserUtil.defaultSeedUserMap());
        idGenerator = new AtomicLong(userMap.size() + 1);
    }

    @Override
    public User findById(Long id) {
        return Optional.ofNullable(userMap.get(id))
                .orElseThrow(() -> new GlobalException("User not found with id: " + id));
    }

    @Override
    public User add(User user) {
        user.setId(idGenerator.getAndIncrement());
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
}

package org.example.java.libraray.management.core.repository;

import org.example.java.libraray.management.core.model.User;

import java.util.List;

public interface UserRepository {
    User findById(Long id);

    User add(User user);

    List<User> findAll();
}

package org.example.java.libraray.management.core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.java.libraray.management.core.model.User;
import org.example.java.libraray.management.core.repository.UserRepository;
import org.example.java.libraray.management.util.UserUtil;

@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void addUser() {
        User user = UserUtil.inputUserAddDetails();
        userRepository.add(user);
        log.info("✅ User added successfully!");
    }

    public void listUsers() {
        userRepository.findAll().forEach(System.out::println);
    }
}

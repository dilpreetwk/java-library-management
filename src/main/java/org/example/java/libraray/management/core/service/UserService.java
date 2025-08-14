package org.example.java.libraray.management.core.service;

import org.example.java.libraray.management.core.model.User;
import org.example.java.libraray.management.infra.registry.RepositoryRegistry;
import org.example.java.libraray.management.infra.repository.UserRepository;
import org.example.java.libraray.management.util.UserUtil;

import java.util.Scanner;

public class UserService {

    private final UserRepository userRepository = RepositoryRegistry.userRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void addUser() {
        User user = UserUtil.inputUserAddDetails();
        userRepository.add(user);
        System.out.println("✅ User added successfully!");
    }

    public void listUsers() {
        userRepository.findAll().forEach(System.out::println);
    }
}

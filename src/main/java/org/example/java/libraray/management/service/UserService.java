package org.example.java.libraray.management.service;

import org.example.java.libraray.management.model.User;
import org.example.java.libraray.management.registry.RepositoryRegistry;
import org.example.java.libraray.management.repository.UserRepository;
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

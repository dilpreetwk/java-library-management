package org.example.java.libraray.management.util;

import org.example.java.libraray.management.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static Map<Long, User> defaultSeedUserMap() {
        Map<Long, User> users = new HashMap<>();

        User u1 = new User();
        u1.setId(1L);
        u1.setName("John Doe");
        u1.setEmail("john@doe.com");

        User u2 = new User();
        u2.setId(2L);
        u2.setName("Bob Smith");
        u2.setEmail("bob@smith.com");

        User u3 = new User();
        u3.setId(3L);
        u3.setName("Tango Charlie");
        u3.setEmail("tango@charlie.com");

        users.put(u1.getId(), u1);
        users.put(u2.getId(), u2);
        users.put(u3.getId(), u3);

        return users;
    }

    public static User inputUserAddDetails(){
        User user = new User();

        System.out.print("Enter User ID: ");
        user.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.print("Enter User Name: ");
        user.setName(scanner.nextLine().trim());

        System.out.print("Enter User Email: ");
        user.setEmail(scanner.nextLine().trim());

        return user;
    }
}

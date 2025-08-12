package org.example.java.libraray.management.util;

import org.example.java.libraray.management.model.User;

import java.util.Scanner;

public class UserUtil {

    private static final Scanner scanner = new Scanner(System.in);

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

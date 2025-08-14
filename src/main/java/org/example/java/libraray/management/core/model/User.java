package org.example.java.libraray.management.core.model;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return String.format(
                "👤 User ID: %d%n" +
                "Name: %s%n" +
                "Email: %s%n",
                id,
                name,
                email
        );
    }
}

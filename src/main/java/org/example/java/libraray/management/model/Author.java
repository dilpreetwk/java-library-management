package org.example.java.libraray.management.model;

import lombok.Data;

@Data
public class Author {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return String.format(
                "👤 Author ID: %d%n" +
                        "Name      : %s%n",
                id,
                name
        );
    }
}

package org.example.java.libraray.management.model;

import lombok.Data;

@Data
public class Genre {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return String.format(
                "🏷️ Genre ID: %d%n" +
                        "Name     : %s%n",
                id,
                name
        );
    }
}

package org.example.java.libraray.management.model;

import lombok.Data;

@Data
public class Policy {

    private Integer borrowLimit = 3;
    private Integer borrowDays = 5;
}

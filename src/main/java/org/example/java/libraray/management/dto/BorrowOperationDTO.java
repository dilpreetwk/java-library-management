package org.example.java.libraray.management.dto;

import lombok.Data;

@Data
public class BorrowOperationDTO {

    private Long id;
    private Long bookId;
    private Long userId;
}

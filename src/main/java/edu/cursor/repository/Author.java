package edu.cursor.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Author {
    private int id;
    private String fName;
    private String lName;
}

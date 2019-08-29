package edu.cursor.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class  Book {
    private int id;
    private int authorId;
    private String title;
    private Genre genre;
    private String description;
    private double rate;
}

package com.shadhin.thebooks.books;

import lombok.Data;

import java.util.List;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String isbn;
    private int publicationYear;
    private double price;
    private List<Long> authorIds;
}

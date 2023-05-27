package com.shadhin.thebooks.authors;

import lombok.Data;

@Data
public class AuthorDto {
    private Long id;

    private String name;

    private String email;

    private String biography;
}

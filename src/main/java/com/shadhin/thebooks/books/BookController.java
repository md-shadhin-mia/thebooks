package com.shadhin.thebooks.books;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/book")
public class BookController {
    @GetMapping
    public ResponseEntity getList(){
        return ResponseEntity
                .ok(Arrays.asList("a", "b", "C"));
    }
}

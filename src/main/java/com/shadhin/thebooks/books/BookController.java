package com.shadhin.thebooks.books;

import com.shadhin.thebooks.core.PaginationResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping
    public ResponseEntity<PaginationResponse<Book>> getList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "id") String sortBy
    ){
        return ResponseEntity.ok(bookService.getList(page, limit, sortBy));
    }


    @PostMapping
    public ResponseEntity<Book> createBook(@Validated @RequestBody BookDto bookDto){
        Book book = bookService.create(bookDto, bookDto.getAuthorIds());
        return ResponseEntity.ok(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody BookDto bookDto) {
        Book updatedBook = bookService.updateBook(id, bookDto);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.shadhin.thebooks.authors;

import com.shadhin.thebooks.books.Book;
import com.shadhin.thebooks.core.PaginationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorDto authorDto) {
        Author createdAuthor = authorService.createAuthor(authorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") Long id) {
        Author author = authorService.getAuthorById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") Long id, @RequestBody AuthorDto authorDto) {
        Author updatedAuthor = authorService.updateAuthor(id, authorDto);
        if (updatedAuthor != null) {
            return ResponseEntity.ok(updatedAuthor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") Long id) {
        boolean deleted = authorService.deleteAuthor(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<PaginationResponse<Author>> getList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "id") String sortBy
    ){
        return ResponseEntity.ok(authorService.getList(page, limit, sortBy));
    }
}

package com.shadhin.thebooks.pages;

import com.shadhin.thebooks.authors.Author;
import com.shadhin.thebooks.authors.AuthorService;
import com.shadhin.thebooks.books.Book;
import com.shadhin.thebooks.books.BookService;
import com.shadhin.thebooks.core.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class PageController {
    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;
    @GetMapping
    public String HomePage(Model model){
        List<Book> books = bookService.getList(0, 5, "id").getData();
        model.addAttribute("books",books);
        List<Author> authors = authorService.getList(0, 5, "id").getData();
        model.addAttribute("authors",authors);
        return "home";
    }

    @GetMapping("/books")
    public String books(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int limit,
                        @RequestParam(defaultValue = "id") String sortBy
                        ){
        PaginationResponse<Book> paginationResponse = bookService.getList(page, limit, sortBy);
        model.addAttribute("paginationResponse",paginationResponse);
        return "books";
    }


    @GetMapping("/books/create")
    public String createBook(){
        return "createBook";
    }
    @GetMapping("/books/update/{id}")
    public String updateBook(@PathVariable String id){
        return "updateBook";
    }

    @GetMapping("/authors")
    public String authors(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int limit,
                        @RequestParam(defaultValue = "id") String sortBy
                        ){
        PaginationResponse<Book> paginationResponse = authorService.getList(page, limit, sortBy);
        model.addAttribute("paginationResponse",paginationResponse);
        return "authors";
    }
}

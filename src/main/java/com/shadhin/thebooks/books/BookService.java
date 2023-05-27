package com.shadhin.thebooks.books;

import com.shadhin.thebooks.authors.Author;
import com.shadhin.thebooks.authors.AuthorRepository;
import com.shadhin.thebooks.core.NullPropertyUtils;
import com.shadhin.thebooks.core.PaginationResponse;
import com.shadhin.thebooks.core.PaginationUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public Page<Book> getList(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    public PaginationResponse getList(int page, int limit, String sortBy) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortBy));
        Page<Book> data = bookRepository.findAll(pageable);
        return PaginationUtil.convertPageToPaginationResponse(data);
    }

    public Book create(BookDto bookDto, List<Long> authorIds) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book, NullPropertyUtils.getNullPropertyNames(bookDto));
        List<Author> authors = authorIds.stream()
                .map((authorId) -> authorRepository.findById(authorId).orElse(null))
                .collect(Collectors.toList());
        book.setAuthors(authors);
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(bookDto, book, NullPropertyUtils.getNullPropertyNames(bookDto));
        return bookRepository.save(book);
    }


    public boolean deleteBook(Long id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.shadhin.thebooks.authors;

import com.shadhin.thebooks.books.Book;
import com.shadhin.thebooks.core.PaginationResponse;
import com.shadhin.thebooks.core.PaginationUtil;
import lombok.AllArgsConstructor;
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
public class AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;


    public Author createAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setEmail(authorDto.getEmail());
        author.setBiography(authorDto.getBiography());
        Author savedAuthor = authorRepository.save(author);
        return savedAuthor;
    }

    public Author getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        return author;
    }

    public Author updateAuthor(Long id, AuthorDto authorDto) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            author.setName(authorDto.getName());
            author.setEmail(authorDto.getEmail());
            author.setBiography(authorDto.getBiography());
            Author updatedAuthor = authorRepository.save(author);
            return updatedAuthor;
        }
        return null;
    }

    public boolean deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            authorRepository.delete(author);
            return true;
        }
        return false;
    }

    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return convertToDtoList(authors);
    }

    private AuthorDto convertToDto(Author author) {
        if (author == null) {
            return null;
        }
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setEmail(author.getEmail());
        authorDto.setBiography(author.getBiography());
        return authorDto;
    }

    private List<AuthorDto> convertToDtoList(List<Author> authors) {
        return authors.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PaginationResponse getList(int page, int limit, String sortBy) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortBy));
        Page<Author> data = authorRepository.findAll(pageable);
        return PaginationUtil.convertPageToPaginationResponse(data);
    }
}

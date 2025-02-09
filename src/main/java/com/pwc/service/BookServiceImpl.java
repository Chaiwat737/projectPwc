package com.pwc.service;

import com.pwc.entity.Books;
import com.pwc.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements  BookService{

    @Autowired
    private BookRepository repository;

    public List<Books> getAllBooks() {
        return repository.findAll();
    }

    public Books addBook(Books book) {
        return repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
    public Books updateBook(Long id, Books bookDetails) {
        return repository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setCategory(bookDetails.getCategory());
            return repository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Books borrowBook(Long id, String role) {
        return repository.findById(id).map(books   -> {
            if (books.isBorrowed()) {
                throw new RuntimeException("Book is already borrowed");
            }
            if (!role.equals("MEMBER")) {
                throw new RuntimeException("Only members can borrow books");
            }
            books.setBorrowed(true);
            return repository.save(books);
        }).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Books returnBook(Long id) {
        return repository.findById(id).map(books -> {
            if (!books.isBorrowed()) {
                throw new RuntimeException("Book is not borrowed");
            }
            books.setBorrowed(false);
            return repository.save(books);
        }).orElseThrow(() -> new RuntimeException("Book not found"));
    }
}

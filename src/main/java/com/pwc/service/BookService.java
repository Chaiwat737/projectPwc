package com.pwc.service;

import com.pwc.entity.Books;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.net.InterfaceAddress;
import java.util.List;

public interface BookService {
    public List<Books> getAllBooks() ;

    public Books addBook(Books book) ;

    public void deleteBook(Long id) ;

    public Books borrowBook(Long id, String username, String role) ;

    public Books returnBook(Long id);
    public Books updateBook(Long id, Books bookDetails);
    public List<Books> searchBooks(String keyword);
}

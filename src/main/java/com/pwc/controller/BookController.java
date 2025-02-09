package com.pwc.controller;

import com.pwc.config.JwtService;
import com.pwc.entity.Books;
import com.pwc.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/books")
class BookController {
    @Autowired
    private BookService service;
    @Autowired
    private JwtService jwtService;
    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    @GetMapping
    public List<Books> getBooks() {
        return service.getAllBooks();
    }
    @RequestMapping(value = "addBook", method = RequestMethod.POST)
    public Books addBook(@RequestBody Books book) {
        return service.addBook(book);
    }
    @RequestMapping(value = "updateBook/{id}", method = RequestMethod.PUT)
    public Books updateBook(@PathVariable Long id, @RequestBody Books book) {
        return service.updateBook(id, book);
    }

    @RequestMapping(value = "deleteBook/{id}", method = RequestMethod.POST)
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }
    @RequestMapping(value = "/borrowBook/{id}", method = RequestMethod.PUT)
    public Books borrowBook(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        String role = jwtService.extractClaims(token.replace("Bearer ", "")).get("role", String.class);
        return service.borrowBook(id, role);
    }

    @RequestMapping(value = "/returnBook/{id}", method = RequestMethod.PUT)
    public Books returnBook(@PathVariable Long id) {
        return service.returnBook(id);
    }
}
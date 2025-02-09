package com.pwc.repository;

import com.pwc.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
    List<Books> findByTitleContainingIgnoreCase(String title);
    List<Books> findByAuthorContainingIgnoreCase(String author);
    List<Books> findByCategoryContainingIgnoreCase(String category);
}



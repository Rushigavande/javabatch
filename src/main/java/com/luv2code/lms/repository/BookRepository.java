package com.luv2code.lms.repository;


import com.luv2code.lms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByTitleContainingAndAuthorContaining(String title, String author);
}

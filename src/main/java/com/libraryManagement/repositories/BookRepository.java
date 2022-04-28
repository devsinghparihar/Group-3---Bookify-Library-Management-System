package com.libraryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.libraryManagement.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}

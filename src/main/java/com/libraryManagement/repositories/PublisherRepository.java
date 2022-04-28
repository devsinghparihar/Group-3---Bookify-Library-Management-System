package com.libraryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagement.entities.Publisher;



public interface PublisherRepository  extends JpaRepository<Publisher, Long> {

}

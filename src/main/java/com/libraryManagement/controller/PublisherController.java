package com.libraryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManagement.entities.Book;
import com.libraryManagement.entities.Publisher;
import com.libraryManagement.repositories.BookRepository;
import com.libraryManagement.repositories.MemberRepository;
import com.libraryManagement.repositories.PublisherRepository;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

	@Autowired
	private  PublisherRepository publisherRepository;
	@PostMapping("/create-publisher")
	public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher)
	{
		Publisher publishers=publisherRepository.save(publisher);
		return new ResponseEntity<Publisher>(publishers,HttpStatus.CREATED);
	}
	@GetMapping("/publisher-list")
	// @RequestMapping(value="create-student",method="POST")
	public List<Publisher> getAllPublishers() {
		return (List<Publisher>) publisherRepository.findAll();
	}
	@GetMapping("/publisher-list/{publisherId}")
	public ResponseEntity<Publisher> getPublisherById(@PathVariable long publisherId){
		
		Publisher publisher = publisherRepository.findById(publisherId).get();
		return new ResponseEntity<Publisher>(publisher,HttpStatus.OK);
		
	}
	@PutMapping("/update-publisher")
	public Publisher updatePublisher(@RequestBody Publisher obj) {
		return publisherRepository.save(obj);
	}

	@DeleteMapping("/delete-publisher/{publisherId}")
	public ResponseEntity<Book> deleteBook(@PathVariable long publisherId) {

		 publisherRepository.deleteById(publisherId);
		 return new ResponseEntity<Book>(HttpStatus.OK);
	}
}

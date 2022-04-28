package com.libraryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.validation.Valid;
import com.libraryManagement.entities.Book;
import com.libraryManagement.exception.BookAlreadyPresentexception;
import com.libraryManagement.exception.BookNotFoundException;
import com.libraryManagement.exception.BooksAremptyException;
import com.libraryManagement.repositories.BookRepository;


 
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository bookrepository;
	@PostMapping("/create-book")
	public ResponseEntity<Book> createBook(@RequestBody Book book) 
	{
		if(bookrepository.findById(book.getBookId()).isPresent()) {
			
			throw new BookAlreadyPresentexception("Book with Id"+book.getBookId()+ "is already present");
		}
		Book books=bookrepository.save(book);
		return new ResponseEntity<Book>(books,HttpStatus.CREATED);
	}
	@GetMapping("/book-list")
	
	public List<Book> getAllBooks()   {
		List<Book> list=bookrepository.findAll();	
		if(list.isEmpty()) 		{
			throw new BooksAremptyException("Book list is Empty");
		}
		return (list) ;
	}
	@GetMapping("/book-list/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable long bookId) {
		if(!bookrepository.findById(bookId).isPresent())
			throw new BookNotFoundException("Book Not Found with Id"+bookId);
			
		Book book = bookrepository.findById(bookId).get();
		return new ResponseEntity<Book>(book,HttpStatus.OK);
		
	}
	@PutMapping("/update-book")
	public Book updateBook(@RequestBody Book obj) {
		return bookrepository.save(obj);
	}

	@DeleteMapping("/delete-book/{bookId}")
	public ResponseEntity<Book> deleteBook(@PathVariable long bookId){
		if(!bookrepository.findById(bookId).isPresent())
			throw new BookNotFoundException("Book Not Found with Id"+bookId);
		 bookrepository.deleteById(bookId);
		 return new ResponseEntity<Book>(HttpStatus.OK);
	}
}

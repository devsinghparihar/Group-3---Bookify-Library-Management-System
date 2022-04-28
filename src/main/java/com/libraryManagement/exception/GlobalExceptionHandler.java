package com.libraryManagement.exception;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	//Employee exceptions
	
	@ExceptionHandler(BookAlreadyPresentexception.class)
	public ResponseEntity<ErrorDetails> handleEmployeeAlreadyPresentException(BookAlreadyPresentexception ex,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(BooksAremptyException.class)
	public ResponseEntity<ErrorDetails> handleEmployeeAlreadyPresentException(BooksAremptyException ex,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleEmployeeAlreadyPresentException(BookNotFoundException ex,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleEmployeeAlreadyPresentException(StudentNotFoundException ex,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
//	Member exceptions
	
	
}

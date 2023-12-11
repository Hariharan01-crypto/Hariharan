package com.example.Book_Store_Management.Exceptiono;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class BookStore_Handler {

	@ExceptionHandler(ClassNotFound.class)
	ResponseEntity<String> excep(ClassNotFound ex) throws Exception  {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	@ExceptionHandler(UpdateIdNotFound.class)
	ResponseEntity<String> excep444(UpdateIdNotFound ex) throws Exception  {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	
	@ExceptionHandler(ClassNotFoundException.class)
	ResponseEntity<String> excep1(ClassNotFoundException ex) throws Exception {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("handle it..");
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<String> excep1(Exception e) throws Exception {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reason: You have enter the wrong input..."+"\n Exception: "+e.getMessage());
	}

	
	
	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<String> excep11(ConstraintViolationException ex) throws Exception {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation Error Occurred..please enter the input Correctly...");
	}

}

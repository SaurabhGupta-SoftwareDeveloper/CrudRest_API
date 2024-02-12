package org.jsp.crud._rest.exception;

import java.util.NoSuchElementException;

import org.jsp.crud._rest.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyException {

	  @Autowired 
	  ResponseStructure<String>structure;
	 
	 @ExceptionHandler(DataIntegrityViolationException.class)
	 public ResponseEntity<ResponseStructure<String>> handler(DataIntegrityViolationException exception){
		  structure.setMessage("Data not saved");
		  structure.setStatus(HttpStatus.BAD_REQUEST.value());
		  structure.setData("Mobile number is already");
		  return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	 }
	 @ExceptionHandler(NoSuchElementException.class)
		public ResponseEntity<ResponseStructure<String>> handler(NoSuchElementException exception) {
			structure.setMessage("Data Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(exception.getMessage());

			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		}
}

package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotfoundException extends RuntimeException {

	public StudentNotfoundException(String message) {
		super(message);
	}
}

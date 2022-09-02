package com.niit.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.niit.exception.StudentServiceException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(StudentServiceException.class)
	public ResponseEntity<ErrorInfo> studentServiceExceptionHandler(StudentServiceException exception) {
		ErrorInfo errInfo = new ErrorInfo();
		errInfo.setErrorMessage(exception.getMessage());
		errInfo.setErrorCode(HttpStatus.NOT_FOUND.value());
		errInfo.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errInfo, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
		ErrorInfo errInfo = new ErrorInfo();
		errInfo.setErrorMessage("Some exception occured! Please check Logs");
		errInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errInfo.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errInfo, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());

		String errorMsg = exception.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.joining(", "));
		errorInfo.setErrorMessage(errorMsg);
		errorInfo.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorInfo> pathExceptionHandler(ConstraintViolationException exception) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		String errorMsg = exception.getConstraintViolations().stream().map(x -> x.getMessage())
				.collect(Collectors.joining(", "));
		errorInfo.setErrorMessage(errorMsg);
		errorInfo.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

}

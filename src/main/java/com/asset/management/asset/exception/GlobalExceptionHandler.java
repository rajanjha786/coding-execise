package com.asset.management.asset.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice("com.asset.management.asset.controller")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{

  @ExceptionHandler(NoNodeFoundException.class)
  public final ResponseEntity<ErrorMessage> handleDashboardException(NoNodeFoundException theNoNodeFoundException,
      WebRequest request) {
    ErrorMessage message = new ErrorMessage(theNoNodeFoundException.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(message);
  }

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ErrorMessage> handleGenericException(Exception exception,
      WebRequest request) {
    ErrorMessage message = new ErrorMessage(exception.getMessage());
    return ResponseEntity.badRequest()
        .body(message);
  }
}

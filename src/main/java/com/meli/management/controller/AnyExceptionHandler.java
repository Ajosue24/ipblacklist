package com.meli.management.controller;

import com.meli.management.commons.StandardJsonResponse;
import com.meli.management.exception.BusinessException;
import com.meli.management.exception.PetitionerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice(
        annotations = RestController.class)
public class AnyExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseEntity<StandardJsonResponse<Void>> validationError(final BusinessException ex) {
        StandardJsonResponse error = new StandardJsonResponse().onlyErrorBadRequest(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PetitionerException.class)
    @ResponseBody
    public ResponseEntity<StandardJsonResponse<Void>> validationError(final PetitionerException ex) {
        StandardJsonResponse error = new StandardJsonResponse().onlyErrorBadRequest(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

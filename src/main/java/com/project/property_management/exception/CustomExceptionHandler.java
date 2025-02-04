package com.project.property_management.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

// Marking the class as ControllerAdvice makes Springboot come here when exception occurs.
@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException exception){
        List<ErrorModel> errorModels = new ArrayList<>();
        ErrorModel errorModel = null;
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        for(FieldError fe : fieldErrors){
            logger.debug("Inside field validation {} - {}", fe.getField(), fe.getDefaultMessage());
            logger.info("Inside field validation {} - {}", fe.getField(), fe.getDefaultMessage());
            errorModel = new ErrorModel();
            errorModel.setErrorCode(fe.getField());
            errorModel.setErrorMessage(fe.getDefaultMessage());
            errorModels.add(errorModel);
        }
        return new ResponseEntity<List<ErrorModel>>(errorModels, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException) {
        for(ErrorModel errorModel: businessException.getErrors()){
            logger.debug("Inside field validation {} - {}", errorModel.getErrorCode(), errorModel.getErrorMessage());
            logger.info("Inside field validation {} - {}",  errorModel.getErrorCode(), errorModel.getErrorMessage());
            logger.warn("Inside field validation {} - {}",  errorModel.getErrorCode(), errorModel.getErrorMessage());
            logger.error("Inside field validation {} - {}",  errorModel.getErrorCode(), errorModel.getErrorMessage());
        }
        return new ResponseEntity<List<ErrorModel>>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
    }
}

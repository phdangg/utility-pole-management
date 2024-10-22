package com.evn.utilitypolemanagement.exceptions;

import com.evn.utilitypolemanagement.exceptions.CapleType.CableTypeAlreadyExistsException;
import com.evn.utilitypolemanagement.exceptions.CapleType.CableTypeNotFoundException;
import com.evn.utilitypolemanagement.exceptions.Pole.PoleAlreadyExistsException;
import com.evn.utilitypolemanagement.exceptions.Pole.PoleNotFoundException;
import com.evn.utilitypolemanagement.exceptions.PriceList.PriceListNotFoundException;
import com.evn.utilitypolemanagement.exceptions.PriceListPole.PriceListPoleNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PoleAlreadyExistsException.class)
    public ProblemDetail handleDuplicatePoleException(PoleAlreadyExistsException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,e.getMessage());
    }
    @ExceptionHandler(PoleNotFoundException.class)
    public ProblemDetail handlePoleNotFoundException(PoleNotFoundException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());
    }
    @ExceptionHandler(PriceListNotFoundException.class)
    public ProblemDetail handlePriceListNotFoundException(PriceListNotFoundException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());
    }
    @ExceptionHandler(PriceListPoleNotFound.class)
    public ProblemDetail handlePriceListPoleNotFound(PriceListPoleNotFound e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());
    }
    @ExceptionHandler(CableTypeNotFoundException.class)
    public ProblemDetail handleCapleTypeNotFoundException(CableTypeNotFoundException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());
    }
    @ExceptionHandler(CableTypeAlreadyExistsException.class)
    public ProblemDetail handleCableTypeAlreadyExistsException(CableTypeAlreadyExistsException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());
    }
}

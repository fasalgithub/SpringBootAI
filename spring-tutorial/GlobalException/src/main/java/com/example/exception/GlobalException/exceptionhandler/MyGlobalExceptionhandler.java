package com.example.exception.GlobalException.exceptionhandler;


import com.example.exception.GlobalException.customexception.InvalidDateException;
import com.example.exception.GlobalException.customexception.NoSuchElementFoundException;
import com.example.exception.GlobalException.exceptionformatter.MessageBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Set;

@ControllerAdvice
public class MyGlobalExceptionhandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<?> invalidDateException(InvalidDateException invalidDateException, WebRequest request)
    {
        MessageBody messageBody = new MessageBody();
        messageBody.setLocalDateTime(LocalDateTime.now());
        messageBody.setHttpStatus(HttpStatus.NO_CONTENT);
        messageBody.setErrMsg(invalidDateException.getMessage());
        messageBody.setDetail(request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(messageBody);
    }
    @ExceptionHandler(NoSuchElementFoundException.class)
    public ResponseEntity<?> noSuchElementFoundException(NoSuchElementFoundException noSuchElementFoundException, WebRequest request)
    {
        MessageBody messageBody = new MessageBody();
        messageBody.setLocalDateTime(LocalDateTime.now());
        messageBody.setHttpStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        messageBody.setErrMsg(noSuchElementFoundException.getMessage());
        messageBody.setDetail(request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                .body(messageBody);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalException(Exception exception, WebRequest request)
    {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getLocalizedMessage());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        MessageBody messageBody = new MessageBody();
        messageBody.setLocalDateTime(LocalDateTime.now());
        messageBody.setHttpStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        messageBody.setErrMsg("your operation is not supported");
        messageBody.setDetail(request.getDescription(false));

       return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(messageBody);
    }


}

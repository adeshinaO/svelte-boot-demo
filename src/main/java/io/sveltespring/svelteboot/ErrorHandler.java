package io.sveltespring.svelteboot;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> error(Exception e, WebRequest request) throws Exception {
        System.out.println("HEEELLEELELLELELELELLE:" +e.getMessage());
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(e, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

}

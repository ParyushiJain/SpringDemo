package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.entity.errorMsg;
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(DeptNotFoundException.class)
     public ResponseEntity<errorMsg> DeptNotFoundException(DeptNotFoundException exc,WebRequest rqt) {
    	 errorMsg msg=new errorMsg(HttpStatus.NOT_FOUND,exc.getMessage());
    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
     }
}

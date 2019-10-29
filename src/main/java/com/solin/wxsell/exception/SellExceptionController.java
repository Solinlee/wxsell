package com.solin.wxsell.exception;


import com.solin.wxsell.controller.HelleWorldController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(assignableTypes = {HelleWorldController.class})
@ResponseBody
public class SellExceptionController {


    private final Logger log = LoggerFactory.getLogger(SellExceptionController.class);
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<SellException> ex1(RuntimeException e){
        log.error(e.getMessage(),e);
        return  ResponseEntity.status(400).body(new SellException(e));
    }
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<SellException> ex2(NullPointerException e){
        log.error(e.getMessage(),e);
        return  ResponseEntity.status(400).body(new SellException(e));
    }
}

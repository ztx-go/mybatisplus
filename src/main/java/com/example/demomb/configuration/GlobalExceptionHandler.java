package com.example.demomb.configuration;

import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseModel MyExceptionHandle(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        BindingResult result = exception.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(error -> {
                System.out.println("field" + error.getField() + ", msg:" + error.getDefaultMessage());
                errorMsg.append(error.getField() + error.getDefaultMessage()).append(" ");
            });
        }

        exception.printStackTrace();
        return new ResponseModel(new Date().getTime(), null, ResponseCode._402, errorMsg.toString());
    }
}

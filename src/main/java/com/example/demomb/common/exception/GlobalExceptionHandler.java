package com.example.demomb.common.exception;

import com.example.demomb.controller.model.ResponseCode;
import com.example.demomb.controller.model.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseModel MyExceptionHandle(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        BindingResult result = exception.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(error -> {
//                System.out.println("field" + error.getField() + ", msg:" + error.getDefaultMessage());
                LOGGER.error("==所属field{}，报错信息{}==", error.getField(), error.getDefaultMessage());
                errorMsg.append(error.getField() + error.getDefaultMessage()).append(" ");
            });
        }

        exception.printStackTrace();
        return new ResponseModel(new Date().getTime(), null, ResponseCode._402, errorMsg.toString());
    }

    @ExceptionHandler(value = TokenException.class)
    @ResponseBody
    public ResponseModel MyExceptionHandleForToken(TokenException exception) {
        exception.printStackTrace();
        return new ResponseModel(new Date().getTime(), null, ResponseCode._401, exception.getMessage());
    }
}

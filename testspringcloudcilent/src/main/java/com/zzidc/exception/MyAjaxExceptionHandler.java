package com.zzidc.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyAjaxExceptionHandler {
    @ExceptionHandler(value = MyRutimeException.class)
    public JsonResult defaultErrorHandler(HttpServletRequest request, MyRutimeException e) throws Exception {
        e.printStackTrace();
        return JsonResult.errorException(e);
    }
}

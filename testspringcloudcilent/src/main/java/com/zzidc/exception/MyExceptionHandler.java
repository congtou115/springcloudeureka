package com.zzidc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = {MyRutimeException.class})
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, MyRutimeException e) throws Exception {
        e.printStackTrace();
        
        if (isAjax(request)) {
            return JsonResult.errorException(e);
        } 
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e.getMessage());
        mav.setViewName("error/500");
        return mav;
    }
	
    public static boolean isAjax(HttpServletRequest httpRequest) {
        String xRequestedWith = httpRequest.getHeader("X-Requested-With");
        return (xRequestedWith != null && "XMLHttpRequest".equals(xRequestedWith));
    }
    
    @ExceptionHandler(value = {RuntimeException.class,Exception.class})
    public ModelAndView errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e.getMessage());
        mav.setViewName("error/500");
        return mav;
    }
    
}

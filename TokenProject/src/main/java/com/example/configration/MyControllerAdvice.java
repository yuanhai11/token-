package com.example.configration;

import com.example.common.Response;
import com.example.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyControllerAdvice {
    @ResponseBody
    @ExceptionHandler
    public Response serviceExceptionHandler(ServiceException serviceException){
        Response response = new Response(Integer.valueOf(serviceException.getCode()), serviceException.getMsg(),null);
        return response;

    }

}

package com.bjpowernode.mp06.vo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultData<String> exception(Exception e) {

        return ResultData.fail(ReturnCode.RC500.getCode(),e.getMessage());
    }

}

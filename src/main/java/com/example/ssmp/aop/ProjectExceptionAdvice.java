package com.example.ssmp.aop;

import com.example.ssmp.utils.Constant;
import com.example.ssmp.utils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler
    public R doHandlerException(Exception ex){
        ex.printStackTrace();
        return new R(false,null, Constant.buzz);
    }
}

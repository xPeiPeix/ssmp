package com.example.ssmp.utils;

import com.example.ssmp.controller.BookController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseClass {

    private Class clazz;
    public  Logger log;

    public BaseClass(){
        clazz = this.getClass();
        log = LoggerFactory.getLogger(clazz);
    }
}

package com.example.ssmp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(properties = {"test.prop=testValue01"})
@SpringBootTest(args = {"--test.prop=testValue02"})
public class TempPropertiesTest {

    @Value("${test.prop}")
    private String msg;

    @Test
    void testTempProperties(){
        System.out.println(msg);
    }
}

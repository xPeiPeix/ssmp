package com.example.ssmp;

import com.example.ssmp.config.RandomDataConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RandomDataTest {

    @Autowired
    private RandomDataConfig randomDataConfig;

    @Test
    void randomDataTest(){
        System.out.println(randomDataConfig);
    }
}

package com.example.ssmp;

import com.example.ssmp.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
public class MongoDBTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void saveDB(){
        Book book = new Book();
        book.setId(2);
        book.setName("springboot2");
        book.setDescription("springboot2");
        book.setType("springboot2");

        mongoTemplate.save(book);
    }

    @Test
    void findDB(){
        List<Book> books = mongoTemplate.findAll(Book.class);
        System.out.println(books);
    }

}

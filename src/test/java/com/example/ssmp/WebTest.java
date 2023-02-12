package com.example.ssmp;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class WebTest {

    @Autowired
    public MockMvc mvc;

    @Test
    void testWebGet() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.get("/books");
        mvc.perform(builder);
    }

    @Test
    void testWebDelete() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.delete("/books/68");
        mvc.perform(builder);
    }

    @Test
    void testStatus() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);

        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();

        action.andExpect(ok);
    }

    @Test
    void testBody() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.get("/books/testBody");
        ResultActions action = mvc.perform(builder);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.string("hello,MockMvc");

        action.andExpect(result);
    }

    @Test
    void testJson() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.get("/books/testJson");
        ResultActions action = mvc.perform(builder);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\"id\":null,\"type\":null,\"name\":null,\"description\":\"hello,MockMvc\"}");

        action.andExpect(result);
    }

    @Test
    void testContentType() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.get("/books/testJson");
        ResultActions action = mvc.perform(builder);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type","application/json");

        action.andExpect(contentType);
    }

    @Test
    void testMock() throws Exception{
        RequestBuilder builder = MockMvcRequestBuilders.get("/books/testJson");
        ResultActions action = mvc.perform(builder);

        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        action.andExpect(ok);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\"id\":null,\"type\":null,\"name\":null,\"description\":\"hello,MockMvc\"}");
        action.andExpect(result);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type","application/json");
        action.andExpect(contentType);
    }


}

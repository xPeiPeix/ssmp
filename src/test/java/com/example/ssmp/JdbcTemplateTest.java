package com.example.ssmp;

import com.example.ssmp.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Transactional
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    void testJdbcTemplateQueryMap(){

        String sql = "select * from tbl_book";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }

    @Test
    void testJdbcTemplateQueryBook(){

        String sql = "select * from tbl_book";
        RowMapper<Book> rm = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setType(rs.getString("type"));
                book.setDescription(rs.getString("description"));
                return book;
            }
        };
        List<Book> list = jdbcTemplate.query(sql,rm);
        System.out.println(list);
    }

    @Test
    void testJdbcTemplateSave(){
        String sql = "insert into tbl_book values(101001,'springboot1','springboot2','springboot3')";
        jdbcTemplate.update(sql);
    }
}

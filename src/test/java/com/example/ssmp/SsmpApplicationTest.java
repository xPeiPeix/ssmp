package com.example.ssmp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ssmp.dao.BookDao;
import com.example.ssmp.pojo.Book;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
//@Rollback(value = true)
class SsmpApplicationTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(2));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setDescription("description");
        book.setName("name");
        book.setType("type");
        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setDescription("description");
        book.setId(5);
        book.setName("name");
        book.setType("type_test");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(52);
    }

    @Test
    void testGetAll(){
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testGetPage(){
        IPage page = new Page(2,5);
        bookDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","Spring");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
        String name = "1";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Book::getName,name);
        bookDao.selectList(lqw);
    }

    //动态sql
    @Test
    void testGetBy3(){
        String name = "1";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(name != null,Book::getName,name);
        bookDao.selectList(lqw);
    }

}

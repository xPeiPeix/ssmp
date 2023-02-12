package com.example.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ssmp.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}

package org.example.mapper;

import org.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//@Mapper
public interface UserMapper {
    //查询
    List<User> findAll();
}


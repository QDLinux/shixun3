package org.example.service;

import org.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查询部门数据
    List<Dept> findAll();

    //根据id删除数据
    void deleteById(Integer id);

    //保存部门
    void add(Dept dept);

    void update(Dept dept);

    Dept findById(Integer id);
}

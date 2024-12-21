package org.example.service;

import org.example.dto.EmpDto;
import org.example.pojo.Dept;
import org.example.pojo.Emp;
import org.example.vo.PageResultVo;

import java.util.List;

public interface EmpService {
    //查询员工数据
    PageResultVo findAll(EmpDto empDto);

    //员工新增
    void add(Emp emp);

    //查询一个员工数据
    Emp findById(String id);

    //修改
    void update(Emp emp);

    void delete(String ids);

    String login(Emp emp);
}

package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.dto.EmpDto;
import org.example.pojo.Dept;
import org.example.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface EmpMapper {

    List<Emp> findAll(EmpDto empDto); //查询员工

    void add(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp findById(String id);

    void update(Emp emp);

    void delete(String ids);

    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp findByNameAndPwd(Emp emp);
    Emp login(Emp emp);
}

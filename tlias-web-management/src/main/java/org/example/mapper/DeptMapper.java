package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Dept;

import java.util.List;

//@Mapper
public interface DeptMapper {
//    @Select("select * from dept")
    List<Dept> findAll(); //查询部门

//    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);//删除部门

//    @Insert("insert into dept values(#{id},#{name},#{createTime},#{updateTime})")
    void add(Dept dept);//新增部门

    void update(Dept dept);//修改部门

    Dept findById(Integer id);//根据ID查询部门
}

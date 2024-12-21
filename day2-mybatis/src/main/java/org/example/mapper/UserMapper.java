package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.User;
import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    public List<User> findAll(); //查询
    public void save(User user);//保存
    public void update(User user);//修改
    @Delete("delete from user where uid=#{id}")
    public void delete(Integer id);//删除


    //根据多条件查询 id>10 and password= 1234
    public List<User> findByCondition(@Param("id") Integer uid , @Param("pwd") String password);
    public List<User> findByCondition2(User user);

    //模糊查询
    public List<User> findByName(String name);
}


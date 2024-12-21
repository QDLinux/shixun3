package org.example.service.impl;

import org.example.mapper.DeptMapper;
import org.example.pojo.Dept;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service //表明身份
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    /**
     *  查询所有部门
     */
    @Override
    public List<Dept> findAll() {
        List<Dept> deptList = deptMapper.findAll();
        return deptList;
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    /**
     * 保存部门
     * @param dept
     */
    @Override
    public void add(Dept dept) {
        //补充前端没有传递的两个字段
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    /**
     * 修改部门
     * @param dept
     */
    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @Override
    public Dept findById(Integer id) {
        Dept dept = deptMapper.findById(id);
        return dept;
    }
}

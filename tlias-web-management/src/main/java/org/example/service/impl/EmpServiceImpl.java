package org.example.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.dto.EmpDto;
import org.example.mapper.DeptMapper;
import org.example.mapper.EmpMapper;
import org.example.pojo.Dept;
import org.example.pojo.Emp;
import org.example.service.DeptService;
import org.example.service.EmpService;
import org.example.utils.JwtUtils;
import org.example.vo.PageResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service //表明身份
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    /**
     * 查询员工
     * @return
     */
    @Override
    public PageResultVo findAll(EmpDto empDto) {
        //PageHelper开始自动分页
        PageHelper.startPage(empDto.getPage(),empDto.getPageSize());
        //查询所有员工信息
        List<Emp> empList = empMapper.findAll(empDto);
        //查询该表总数据量
        Page page = (Page)empList;
        return new PageResultVo(page.getTotal(), empList);
    }

    //员工新增
    @Override
    public void add(Emp emp) {
        //前端传入7个，需要补充4个，id数据库自动生成，只需要补3个
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setPassword("1234");
        empMapper.add(emp);
    }

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @Override
    public Emp findById(String id) {

        Emp emp = empMapper.findById(id);
        return emp;
    }

    /**
     * 修改员工
     * @param emp
     */
    @Override
    public void update(Emp emp) {
        //设置员工最后一次修改的时间
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    /**
     * 删除员工
     * @param id
     */
    @Override
    public void delete(String ids) {
        //可以直接传ids串
        empMapper.delete(ids);
        //删除多个id，需要将字符串转换为数组
//        String[] id = ids.split(",");
//        StringBuilder newids= new StringBuilder("'");
//        for (int i = 0; i < id.length; i++) {
//            newids.append(id[i]);
//            if(i!=id.length-1){
//                newids.append("' , '");
//            }
//            else {
//                newids.append("' ");
//            }
//        }
//        empMapper.delete(newids.toString());
    }


    /**
     * 登录
     * 糊涂工具包 封装了开发中很多常用的工具类
     */
    @Override
    public String login(Emp emp) {
        //1.判断用户必须输入了用户名和密码
        if(StrUtil.isEmpty(  emp.getUsername() )){
            throw  new RuntimeException("用户名不能为空");
        }
        if(StrUtil.isEmpty(  emp.getPassword() )){
            throw  new RuntimeException("密码不能为空");
        }
        //2.数据库查询登录
        Emp loginEmp = empMapper.findByNameAndPwd( emp );
        if(loginEmp != null){ //登录成功
            System.out.println("登录成功");
            //需要将成功的用户 加密后传给浏览器
            Map map = new HashMap<>();
            map.put("id" , loginEmp.getId());
            map.put("username", loginEmp.getUsername());
            String token = JwtUtils.generateJwt(map);
            return token;
        }else{ //用户名或者密码输入错误
            System.out.println("登录失败");
        }

        return null;
    }

}

package org.example.web.controller;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Dept;
import org.example.service.DeptService;
import org.example.vo.ResultVo;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //表明身份
public class DeptController {


    @Autowired //注入service对象
    private DeptService deptService;
    /**
     * 查询所有部门信息
     * @return
     */
    @GetMapping("/depts")
    public ResultVo findAll(){
        //调用service查询数据
        List<Dept> deptList =  deptService.findAll();
        //返回数据
        return ResultVo.success(deptList);
    }


    /**
     * 删除部门
     * 一旦请求路径上有{变量}  叫做路径参数
     * /depts/{id}    路径上携带参数例如:  /depts/1   /depts/2  /depts/3
     * 浏览器地址栏默认所有的路径全都是get请求
     *
     *
     * 路径参数获得 和之前获得的方式不一样  必须要加上一个特殊的注解 @PathVariable
     * @PathVariable 作用: 就是获得地址中的参数的 但是变量名 要跟 {id} 变量名一致
     */
    @DeleteMapping("/depts/{id}")
    public ResultVo deleteById(@PathVariable  Integer id){
        deptService.deleteById(id);
        return ResultVo.success();
    }


    /**
     * 新增部门
     * 方式1:  如果请求参数 是application/json  且参数只有一个的情况下 我们直接使用 String  接收
     * 方式2:  如果请求参数是application/json  但参数需要使用对象来接收  需要给对象加入一个额外的注解
     * 注解名称是 @RequestBody  自动的将json格式数据转换对象
     *
     * 如果使用对象直接接收  要求: 数据不能是json  是key =value&key=value的格式
     */
    @PostMapping("/depts")
    public ResultVo add(@RequestBody Dept dept){
        deptService.add(dept);
        return ResultVo.success();
    }

    /**
     * 修改部门
     */
    @PutMapping("/depts")
    public ResultVo update(@RequestBody Dept dept){
        deptService.update(dept);
        return ResultVo.success();
    }

    /**
     * 根据id查询部门
     */
    @GetMapping("/depts/{id}")
    public ResultVo findById(@PathVariable Integer id){
        Dept dept = deptService.findById(id);
        return ResultVo.success(dept);
    }
}

package org.example.web.controller;

import org.example.dto.EmpDto;
import org.example.pojo.Dept;
import org.example.pojo.Emp;
import org.example.service.DeptService;
import org.example.service.EmpService;
import org.example.vo.PageResultVo;
import org.example.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //表明身份
public class EmpController {


    @Autowired //注入service对象
    private EmpService empService;
    /**
     * 查询所有员工信息
     * @return
     */
    @GetMapping("/emps")
    public ResultVo findAll(EmpDto empDto){
        PageResultVo pageResultVo = empService.findAll(empDto);
        //返回数据
        return ResultVo.success(pageResultVo);
    }

    /**
     * 新增员工
     */
    @PostMapping("/emps")
    public ResultVo add(@RequestBody Emp emp){
        empService.add(emp);
        return ResultVo.success();
    }

    /**
     * 根据id查询员工
     */
    @GetMapping("/emps/{id}")
    public ResultVo findById(@PathVariable String id){
        Emp emp = empService.findById(id);
        return ResultVo.success( emp );
    }

    /**
     * 修改员工
     */
    @PutMapping("/emps")
    public ResultVo update(@RequestBody Emp emp){
        empService.update(emp);
        return ResultVo.success(  );
    }

    /**
     * 删除员工
     */
    @DeleteMapping("/emps/{ids}")
    public ResultVo delete(@PathVariable String ids){
        empService.delete(ids);
        return ResultVo.success();
    }


}

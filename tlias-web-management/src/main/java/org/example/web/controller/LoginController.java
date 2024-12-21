package org.example.web.controller;

import org.example.pojo.Emp;
import org.example.service.EmpService;
import org.example.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private EmpService empService;
    /**
     * 登录
     */
    @PostMapping("/login")
    public ResultVo login(@RequestBody Emp emp){
        String token = empService.login(emp);
        return ResultVo.success(token);
    }
}

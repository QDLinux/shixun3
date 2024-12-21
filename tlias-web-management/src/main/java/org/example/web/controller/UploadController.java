package org.example.web.controller;

import org.example.pojo.Dept;
import org.example.utils.AliOSSUtils;
import org.example.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController //表明身份
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;
    /**
     * spring mvc专门提供操作文件上传的对象 MultipartFile
     * @param image
     * @return
     */
    @PostMapping("/upload")
    public ResultVo upload(MultipartFile image) throws IOException {
        //阿里云的代码
        String url = aliOSSUtils.upload(image);
        return ResultVo.success(url);
    }
}

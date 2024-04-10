package com.sky.controller.admin;

import com.aliyuncs.exceptions.ClientException;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/admin/common")
public class CommonController {
    @Autowired
    AliOssUtil aliOssUtil;
    @PostMapping("upload")
    public Result<String> upload(MultipartFile file) throws ClientException,IOException{
        log.info("文件上传{}", file.getOriginalFilename());
        String url = aliOssUtil.upload(file);
        return Result.success(url);
    }
}

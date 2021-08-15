package com.yunlian.changgou.service.file.controller;

import com.yunlian.changgou.common.Result;
import com.yunlian.changgou.common.StatusCode;
import com.yunlian.changgou.service.file.model.FastDFSFile;
import com.yunlian.changgou.service.file.util.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FastDFSClient fastDFSClient;

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
        //
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        FastDFSFile fastDFSFile = new FastDFSFile(file.getOriginalFilename(),file.getBytes(),ext);
        String[] str = fastDFSClient.upload(fastDFSFile);
        String resultStr =fastDFSClient.getTrackerUrl()+"/"+str[0]+"/"+str[1];
        return new Result(true, StatusCode.OK,"上传成功");
    }


}

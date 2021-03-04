package com.peach.controller;

import com.alibaba.fastjson.JSON;
import com.peach.Aop.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhangtao
 */

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/getResource")
    @Log(tag = "获取项目下文件测试")
    public String getResource() throws  Exception{
        String path = ResourceUtils.getFile("classpath:templates/123.text").getPath();
        log.info("resource 下文件路径为：{}",path);
        return path;
    }

    @PostMapping("/testMapParams")
    @Log(tag = "map 测试")
    public String testMapParams(@RequestBody Map<String,String> param){
        return JSON.toJSONString(param);
    }

}

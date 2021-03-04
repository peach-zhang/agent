package com.peach.controller;

import com.alibaba.fastjson.JSON;
import com.peach.Aop.Log;
import com.peach.service.ResourcesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ResourcesService  resourcesService;

    @PostMapping("/getResource")
    @Log(tag = "获取项目下文件测试")
    public String getResource(){
        return resourcesService.getResourcesPath();
    }

    @PostMapping("/testMapParams")
    @Log(tag = "map 测试")
    public String testMapParams(@RequestBody Map<String,String> param){
        return JSON.toJSONString(param);
    }

}

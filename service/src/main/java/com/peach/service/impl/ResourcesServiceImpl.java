package com.peach.service.impl;

import com.peach.service.ResourcesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

/**
 * @author zhangtao
 */
@Slf4j
@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Override
    public String getResourcesPath() {
        try {
            String path = ResourceUtils.getFile("classpath:templates/123.text").getPath();
            log.info("resource 下文件路径为：{}",path);
            return path;
        } catch (Exception e) {
            return "获取文件出错！";
        }
    }
}

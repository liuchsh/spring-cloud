package com.cs.ln.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO 写注释
 *
 * @Author liuchsh
 * @date 2018/9/19
 */
@RestController
@RefreshScope
public class MyController {

    @Value("${my.name}")
    private String myName;

    @GetMapping("/myName")
    public String getMyName() {
        return this.myName;
    }

}

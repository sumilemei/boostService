package com.taoz.issdc.iss.controller;

import com.taoz.issdc.iss.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: taoz
 * @date: 2023/2/26 19:39
 * @introduce:
 */
@RestController
@RequestMapping("/test")
public class TestHello {

    @Resource
    private HelloService helloService;
    @RequestMapping("name")
    public String result(){
        String name = helloService.getNmae();
        System.out.println("这里是："+name);
        return "哈哈哈哈,我在"+name+"恭喜boost项目启动成功！！！";
    }

}

package com.taoz.issdc.iss.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taoz.issdc.iss.entity.People;
import com.taoz.issdc.iss.service.HelloService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @RequestMapping("name")
    public String result(){
        String name = helloService.getNmae();
        System.out.println("这里是："+name);
        return "哈哈哈哈,"+name+"恭喜boost项目启动成功！！！";
    }

    @RequestMapping("redis")
    public People redisOp(){
        People p = new People("老虎",21,1,"北京",new String[]{"看书","听歌"},20000.3f);
        String people = JSON.toJSONString(p);
        stringRedisTemplate.opsForValue().set("people",people);
        String people1 = stringRedisTemplate.opsForValue().get("people");
        System.out.println(people1);
        People people2 = JSON.parseObject(people1, People.class);
        System.out.println(people2);

        stringRedisTemplate.opsForHash().put("user:100","name","大老虎");
        stringRedisTemplate.opsForHash().put("user:100","age","25");
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:100");
        Set<Object> keys = stringRedisTemplate.opsForHash().keys("user:100");
        List<Object> values = stringRedisTemplate.opsForHash().values("user:100");
        System.out.println("user:100: "+entries);
        System.out.println("keys:"+keys);
        System.out.println("values:"+values);

        return people2;
    }
}

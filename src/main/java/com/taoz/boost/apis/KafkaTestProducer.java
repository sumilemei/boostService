package com.taoz.boost.apis;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author taozheng
 * @date 2023/3/2 - 21:53
 * @introduce:
 */
@RestController
@RequestMapping("/kafka")
public class KafkaTestProducer {
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("sendMsg")
    public String sendMsg(){
        kafkaTemplate.send("iss-topic-2","msg03051202");
        return "发送完成！！";
    }

}

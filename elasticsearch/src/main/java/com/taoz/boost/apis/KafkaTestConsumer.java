package com.taoz.boost.apis;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author taozheng
 * @date 2023/3/2 - 22:03
 * @introduce:
 */
@RestController
@RequestMapping("/receive")
public class KafkaTestConsumer {

    @RequestMapping("message")
    public void listenMsg(){
        /* 1.创建消费者配置信息 */
        Properties props = new Properties();
        /*2.给配置信息赋值*/
        /*2.1连接的集群*/
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "43.138.62.81:9092");

        /*2.2开启自动提交 */
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        /*2.3 自动提交的延时*/
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "10");
        /*2.4 key value的反序列化 */
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        /*2.5 消费者组 */
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group-1"); // group.id
        /*2.6 重置消费者的offset */
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // 默认值是 lastest

        /* 创建消费者 */
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        /* 订阅主题 */
        consumer.subscribe(Arrays.asList("iss-topic","iss-topic-2"));
        /* 循环拉取 */
        int i =0;
        while(true) {
            if (i++ > 10) break; // 只消费10条数据
            /* 消费消息-获取数据 */
            ConsumerRecords<String, String> consumerRds  = consumer.poll(100);
            /* 解析并打印 ConsumerRecords  */
            /* 遍历 ConsumerRecords*/
            for(ConsumerRecord<String, String> rd : consumerRds) {
                System.out.println("[消费者] " + rd.key() + "--" + rd.value());

            }
        }
        /* 关闭消费者 */
        consumer.close();

    }
}

package com.taoz.boost;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @author taoz
 */
@EnableKafka
@SpringBootApplication
@MapperScan(basePackages = {
        "com.taoz.issdc.**.dao"
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}

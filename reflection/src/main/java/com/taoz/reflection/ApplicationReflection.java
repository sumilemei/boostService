package com.taoz.reflection;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @author taoz
 */
@SpringBootApplication
public class ApplicationReflection {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationReflection.class, args);
    }


}

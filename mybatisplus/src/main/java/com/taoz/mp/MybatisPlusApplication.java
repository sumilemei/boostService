package com.taoz.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class,args);
        // ANSI转义代码开始
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        // ANSI转义代码结束
        System.out.println(ANSI_GREEN + "boost-mybatisPlus已成功启动！" + ANSI_RESET);

    }
}

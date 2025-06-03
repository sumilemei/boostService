package org.taoz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author taoz
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
        // ANSI转义代码开始
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        // ANSI转义代码结束
        System.out.println(ANSI_GREEN + "设计模式已成功启动！" + ANSI_RESET);

    }
}
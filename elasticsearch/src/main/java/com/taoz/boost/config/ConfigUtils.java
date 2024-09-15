package com.taoz.boost.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author taozheng
 * @create 2023-12-18 11:06 下午
 * @introduce:
 */
@Slf4j
@Configuration
public class ConfigUtils implements EnvironmentAware {

    private static Environment env;

    public String getConfig(String path){
        return env.getProperty(path);
    }

    @Override
    public void setEnvironment(Environment environment) {
        log.warn("系统启动环境。。{}",environment);
        env = environment;
    }
}

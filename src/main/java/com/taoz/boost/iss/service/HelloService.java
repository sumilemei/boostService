package com.taoz.boost.iss.service;

import com.taoz.boost.iss.dao.HelloDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: taoz
 * @date: 2023/2/26 19:40
 * @introduce:
 */
@Service
public class HelloService {
    @Resource
    private HelloDao helloDao;

    public String getNmae(){
        return helloDao.TestHello();
    }
}

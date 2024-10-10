package com.taoz.boost.iss.service;

import com.taoz.boost.iss.dao.CompanyDao;
import com.taoz.boost.iss.dao.HelloDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author: taoz
 * @date: 2023/2/26 19:40
 * @introduce:
 */
@Service
public class HelloService {
    @Resource
    private HelloDao helloDao;


    public String getName(){
        return helloDao.TestHello();
    }



}

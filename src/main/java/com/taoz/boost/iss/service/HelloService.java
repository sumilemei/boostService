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
@RequiredArgsConstructor
public class HelloService {
    @Resource
    private HelloDao helloDao;

    private final CompanyDao companyDao;


    public String getName(){
        return helloDao.TestHello();
    }

    public String getTest(){
        List<HashMap<String, Integer>> test = companyDao.getTest();

        for(HashMap<String, Integer> r : test){
            if("诸葛亮".equals(r.get("xm"))){
                return "丞相";
            }else{
                return "大将军";
            }
        }
        return  "啥都不是";
    }

}

package com.taoz.boost.iss.service;

import com.taoz.boost.iss.dao.HelloDao;
import com.taoz.boost.iss.entity.Hotel;
import com.taoz.boost.iss.entity.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class EnhanceTest implements ICompleteCheck{

    @Resource
    private HelloDao helloDao;

    public void dataCompleteCheck(Object obj) {
        People p = (People)obj;
        System.out.println(p.getAddress());
        List<Hotel> allHotel = helloDao.getAllHotel();
        System.out.println(allHotel);
    }
}

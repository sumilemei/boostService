package com.taoz.boost.iss.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.taoz.boost.iss.dao.HotelDao;
import com.taoz.boost.iss.entity.Car;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author taozheng
 * @date 2023/11/14 - 23:23
 * @introduce:
 */
@Service
public class HotelService{
    @Resource
    private HotelDao a;

    public List<Car> getAllHotel(){
        return a.selectList(new QueryWrapper<Car>().select("id","name"));
    }

    public void updateHotel(){
       }




}

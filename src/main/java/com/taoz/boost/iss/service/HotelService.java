package com.taoz.boost.iss.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.taoz.boost.iss.dao.HotelDao;
import com.taoz.boost.iss.entity.Hotel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    public List<Hotel> getAllHotel(){
        return a.selectList(new QueryWrapper<Hotel>().select("id","name"));
    }

    public void updateHotel(){
        Hotel h = new Hotel();
        h.setAddress("成华二");
        a.update(h, new QueryWrapper<Hotel>().eq("name","7天连锁酒店(上海宝山路地铁站店)"));
    }




}

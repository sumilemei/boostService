package com.taoz.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taoz.mp.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface CarMapper extends BaseMapper<Car> {

    @Select("select * from car where id = 1; ")
    Car getRs4();

    Float getRs4Price();


    Map<String,Object> getCarMapById(@Param("id") int id);
}

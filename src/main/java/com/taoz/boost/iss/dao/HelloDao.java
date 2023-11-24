package com.taoz.boost.iss.dao;

import com.taoz.boost.iss.entity.Hotel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: taoz
 * @date: 2023/2/26 19:30
 * @introduce:
 */
@Repository
public interface HelloDao {
    String TestHello();

    @Select("SELECT * FROM tb_hotel where id= ${id};")
    Hotel getHotelInfo(@Param("id") Long id);
}

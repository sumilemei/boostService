package com.taoz.boost.iss.dao;

import com.taoz.boost.iss.entity.Car;
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

    @Select("SELECT * FROM car where id = 1;")
    Car getRs4();
}

package com.taoz.boost.iss.dao;

import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * @author taozheng
 * @date 2024/4/15 - 23:09
 * @introduce:
 */
public interface CompanyDao {

    @Select("SELECT name xm, count(*) cnt FROM company group by name;")
    List<HashMap<String,Integer>> getTest();
}

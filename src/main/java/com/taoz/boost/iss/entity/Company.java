package com.taoz.boost.iss.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author taozheng
 * @date 2024/4/15 - 23:04
 * @introduce:
 */
@Data
@TableName("company")
public class Company {
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private Float salary;
}

package com.taoz.boost.iss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author taozheng
 * @create 2023-07-04 10:49 下午
 * @introduce:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class People{
    private String name;
    private Integer age;
    private Integer gender;
    private String address;
    private String[] hobbies;
    private float salary;

}

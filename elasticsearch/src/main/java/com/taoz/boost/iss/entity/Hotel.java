package com.taoz.boost.iss.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author taozheng
 * @date 2023/11/14 - 21:37
 * @introduce:
 */
@Data
@TableName("tb_hotel")
public class Hotel{
    private Long id;
    private String name;
    private String address;
    private Integer price;
    private Integer score;
    private String brand;
    private String city;
    private String starName;
    @TableField("business")
    private String area;
    private Float latitude;
    private Float longitude;
    private String pic;
}

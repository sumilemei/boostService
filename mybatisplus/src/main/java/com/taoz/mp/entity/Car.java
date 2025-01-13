package com.taoz.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.taoz.mp.entity.enums.CarTypeEnum;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author taozheng
 * @date 2023/11/14 - 21:37
 * @introduce:
 */
@Data
@TableName("car")
public class Car {
    private Long id;
    private String country;
    private String name;
    private Integer tag;
    private Float guidePrice;
    private Integer drive;
    private String brand;
    private String parent;
    private Timestamp birthday;
    private CarTypeEnum energy;
    @TableField(exist = false)
    private String energyDesc;
    private Integer power;
    private Integer torque;
    private String bak1;
    private String bak2;
    private String introduce;
    private Integer size;
    private float score;

    public void setEnergyDesc(){

    }
}

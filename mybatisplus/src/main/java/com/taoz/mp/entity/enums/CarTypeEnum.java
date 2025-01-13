package com.taoz.mp.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum CarTypeEnum {
    YOU(1,"油车"),
    DIAN(2,"电车"),
    HUN(3,"油电混动")
    ;

    @EnumValue
    private Integer code;
    @JsonValue
    private String desc;




}

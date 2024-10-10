package com.taoz.boost.iss.service;

import com.taoz.boost.iss.entity.People;

public enum EnforceDataEnum {

    POLICY_PUT(People.class,EnhanceTest.class);


    private final Class<?> type;
    private final Class<? extends ICompleteCheck> desc;


    EnforceDataEnum(Class<?> peopleClass, Class<? extends ICompleteCheck> enhanceTestClass) {
        this.type = peopleClass;
        this.desc = enhanceTestClass;
    }

    public Class<?> getType(){return type;}
    public Class<? extends ICompleteCheck> getDesc(){return desc;}

    public static Class<? extends ICompleteCheck> getDataByType(Class<?> type){
        for(EnforceDataEnum dataEnum : EnforceDataEnum.values()){
            if(dataEnum.getType() == type){
                return dataEnum.getDesc();
            }
        }
        return null;
    }
}

package com.study.serviceLoader;

public class GovApp implements IProductMode{
    @Override
    public String source() {
        System.out.println("政务应用模式！！");
        return "GovApp";
    }
}

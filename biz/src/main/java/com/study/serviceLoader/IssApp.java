package com.study.serviceLoader;

public class IssApp implements IProductMode{
    @Override
    public String source() {
        System.out.println("自监管模式！！");
        return "IssApp";
    }
}

package com.study.serviceLoader;

public class WeChatApp implements IProductMode{
    @Override
    public String source() {
        System.out.println("微信模式！！");
        return "WeChatApp";
    }
}

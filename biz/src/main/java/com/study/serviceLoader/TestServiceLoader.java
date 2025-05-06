package com.study.serviceLoader;

import java.util.ServiceLoader;

public class TestServiceLoader {
    public static void main(String[] args) {
        ServiceLoader<IProductMode> load = ServiceLoader.load(IProductMode.class);
        for (IProductMode e : load){
            e.source();
        }
    }
}

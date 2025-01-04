package com.taoz.reflection;

import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
public class ReflectionTest {


    public static String type = "com.taoz.reflection.WeChatPay";
    public static String way = "wxPay";

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.taoz.reflection.User");
        System.out.println("------反射方法------");
        //  反射获取构造方法
        Constructor<?> constructors = clazz.getConstructor(String.class, Integer.class, String[].class);
        Object user = constructors.newInstance("小王", 14, new String[]{"画画"});
        System.out.println(user);
        //Method[] methods = clazz.getMethods();
        Method eat = clazz.getDeclaredMethod("eat", User.class);
        eat.setAccessible(true);
        eat.invoke(user,user);
        System.out.println("------反射方法------");
        System.out.println("------反射成员变量------");
        Field[] fields = clazz.getDeclaredFields();
        for(Field f:fields){
            System.out.println(f);
        }
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(user,20);
        System.out.println(user);
        System.out.println("------反射成员变量------");


        System.out.println("---------程序代码不变，利用配置文件加反射实现不同场景下运行不同代码实现业务-----------");
        Class<?> clazz2 = Class.forName(type);
        Method zf = clazz2.getDeclaredMethod(way);
        zf.setAccessible(true);
        zf.invoke(clazz2.newInstance());
        System.out.println("---------程序代码不变，利用配置文件加反射实现不同场景下运行不同代码实现业务-----------");



    }
}

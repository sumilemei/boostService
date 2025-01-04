package com.taoz.reflection;


import lombok.Data;

import java.util.Arrays;

@Data
public class User {

    /**
     * 姓名
     */
    public String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 兴趣爱好
     */
    String[] hobbies;

    public User() {
    }

    public User(String name, Integer age, String[] hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public void work(User user){
        System.out.println(user.getName()+"开始工作了。。。");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }

    private void eat(User user){
        System.out.println(user.getName()+"喜欢偷偷吃饭。。");
    }

}

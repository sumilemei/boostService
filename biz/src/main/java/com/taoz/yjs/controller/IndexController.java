package com.taoz.yjs.controller;


import com.taoz.yjs.pojo.dto.Account;
import com.taoz.yjs.pojo.dto.AttackEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoz
 */
@RestController
@RequestMapping(value = "/index")
@RequiredArgsConstructor
public class IndexController{

    private final ApplicationContext applicationContext;

    @GetMapping(value = "/signUp")
    public void register(){
        List<Account> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Account account = new Account();
            account.setAccount("诸葛亮"+i);
            account.setPassword("123456");
            account.setNickName("卧龙"+i);
            list.add(account);
        }
        AttackEvent event = new AttackEvent(this, list);
        applicationContext.publishEvent(event);
    }

}

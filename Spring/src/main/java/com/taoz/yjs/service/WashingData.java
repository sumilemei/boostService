package com.taoz.yjs.service;

import com.taoz.yjs.pojo.dto.Account;
import com.taoz.yjs.pojo.dto.AttackEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author taoz
 */
@Component
public class WashingData {

    @EventListener
    public void washData(AttackEvent attackEvent) {
        System.out.println("washing data");
        attackEvent.getAccountList().forEach(System.out::println);

    }
}

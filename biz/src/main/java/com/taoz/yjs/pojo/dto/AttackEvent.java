package com.taoz.yjs.pojo.dto;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author taoz
 */
@Component
public class AttackEvent extends ApplicationEvent {
    private CopyOnWriteArrayList<Account> accountList;

    public AttackEvent(Object source, List<Account> accountList) {
        super(source);
        this.accountList = new CopyOnWriteArrayList<>(accountList);
    }

    public CopyOnWriteArrayList<Account> getAccountList() {
        return accountList;
    }
}

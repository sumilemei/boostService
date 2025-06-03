package org.taoz.dp.observer.jg;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Md5StrategyService {


    @EventListener
    public void addMd5Strategy(Md5StrategyAdd addEvent){
        System.out.println("侦察到了新增MD5策略");
        String collect = addEvent.getMd5s().stream().collect(Collectors.joining("、", "[", "]"));
        System.out.println("打印策略是: "+collect);
    }

    @EventListener
    public void removeMd5Strategy(Md5StrategyRemove removeEvent){
        System.out.println("侦察到了删除MD5策略");
        String collect = removeEvent.getMd5s().stream().collect(Collectors.joining("、", "[", "]"));
        System.out.println("打印策略是: "+collect);
    }


    @EventListener
    public void updateMd5Strategy(Md5StrategyUpdate removeEvent){
        System.out.println("侦察到了更新MD5策略");
        String collect = removeEvent.getMd5s().stream().collect(Collectors.joining("、", "[", "]"));
        System.out.println("打印策略是: "+collect);
    }


}

package org.taoz.dp.observer.jg;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StrategyCmd {

    private final ApplicationEventPublisher applicationEventPublisher;

    public StrategyCmd(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Result addStrategy(List<String> md5s){
        String collect = md5s.stream().collect(Collectors.joining("、", "[", "]"));
        System.out.println("新增md5策略,值为: " + collect);
        applicationEventPublisher.publishEvent(new Md5StrategyAdd(this,md5s));
        return new Result<>(ResultStatus.SUCCESS);
    }

    public Result removeStrategy(List<String> md5s){
        String collect = md5s.stream().collect(Collectors.joining("、", "[", "]"));
        System.out.println("删除了md5策略,值为: " + collect);
        applicationEventPublisher.publishEvent(new Md5StrategyRemove(this,md5s));
        return new Result<>(ResultStatus.SUCCESS);
    }

    public Result updateStrategy(List<String> md5s){
        String collect = md5s.stream().collect(Collectors.joining("、", "[", "]"));
        System.out.println("更新了md5策略,值为: " + collect);
        applicationEventPublisher.publishEvent(new Md5StrategyUpdate(this,md5s));
        return new Result<>(ResultStatus.SUCCESS);
    }

}

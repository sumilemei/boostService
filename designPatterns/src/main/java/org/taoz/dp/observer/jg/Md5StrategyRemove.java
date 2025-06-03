package org.taoz.dp.observer.jg;

import org.springframework.context.ApplicationEvent;

import java.util.List;

public class Md5StrategyRemove extends ApplicationEvent {

    private final List<String> md5s;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public Md5StrategyRemove(Object source, List<String> md5s) {
        super(source);
        this.md5s = md5s;
    }

    public List<String> getMd5s(){
        return md5s;
    }
}

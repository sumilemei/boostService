package org.taoz.dp.observer.jg;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestJgController {
    private final StrategyCmd strategyCmd;

    public TestJgController(StrategyCmd strategyCmd) {
        this.strategyCmd = strategyCmd;
    }

    @PostMapping("/add")
    public void add(@RequestBody Strategy strategy) {
        strategyCmd.addStrategy(strategy.getMd5s());
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Strategy strategy) {
        strategyCmd.removeStrategy(strategy.getMd5s());
    }

    @PostMapping("/update")
    public void update(@RequestBody Strategy strategy) {
        strategyCmd.updateStrategy(strategy.getMd5s());
    }
}

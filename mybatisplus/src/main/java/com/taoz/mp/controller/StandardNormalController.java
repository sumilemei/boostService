package com.taoz.mp.controller;

import com.taoz.mp.entity.Car;
import com.taoz.mp.service.MpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: taoz
 * @date: 2025/1/4 14:43
 * @introduce:
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class StandardNormalController {

    private final MpService mpService;

    @RequestMapping("/rs4")
    public Car getRs4(){
        return mpService.getRs4();
    }

    @GetMapping("/audiRs4")
    public Map<String,Car> getAudiRs4(){
        return mpService.getAudiRs4();
    }

    @PostMapping("getCar")
    public List<Car> getCar(@RequestBody Car car){
        return mpService.getCar(car);
    }

    @PostMapping("getCarMap")
    public Map<String,Object> getCarMap(@RequestBody int id){
        Map<String, Object> carMapById = mpService.getCarMapById(id);
        return carMapById;
    }

    @GetMapping("getRs4Price")
    public Float getRs4Price(){
        return mpService.getRs4Price();
    }

    @PostMapping("addCar")
    public int addCars(@RequestBody Car car){
        return mpService.addCar(car);
    }

    @PostMapping("modifyCar")
    public int updateCar(@RequestBody Car car){
        int i = mpService.updateCar(car);
        return i;
    }

    @PostMapping("deleteCar")
    public int deleteCar(@RequestBody Car car){
        int i = mpService.deleteCar(car);
        return i;
    }

}

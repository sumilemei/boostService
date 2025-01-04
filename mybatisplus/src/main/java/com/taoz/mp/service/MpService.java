package com.taoz.mp.service;

import com.taoz.mp.entity.Car;
import com.taoz.mp.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MpService {

    private final CarMapper carMapper;

    public List<Car> getCarList(){
        List<Car> cars = carMapper.selectList(null);
        cars.forEach(System.out::println);
        return cars;
    }

}

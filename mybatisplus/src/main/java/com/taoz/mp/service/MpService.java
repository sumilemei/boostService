package com.taoz.mp.service;

import com.taoz.mp.entity.Car;
import com.taoz.mp.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MpService {

    private final CarMapper carMapper;

    public List<Car> getCarList(){
        List<Car> cars = carMapper.selectList(null);
        cars.forEach(System.out::println);
        return cars;
    }

    public Car getRs4(){
        Car rs4 = carMapper.getRs4();
        return rs4;
    }

    public Map<String,Car> getAudiRs4(){
        Car rs4 = carMapper.getRs4();
        Map<String,Car> response = new HashMap<>();
        response.put("rs4",rs4);
        return response;
    }

    public List<Car> getCar(Car car){
        Map<String,Object> condition = new HashMap<>();
        condition.put("name",car.getName());
        condition.put("parent",car.getParent());
        List<Car> cars = carMapper.selectByMap(condition);
        return cars;
    }

    public Map<String,Object> getCarMapById(int id){
        Map<String, Object> carMapById = carMapper.getCarMapById(id);
        return carMapById;
    }

    public Float getRs4Price(){
        return carMapper.getRs4Price();
    }

    public int addCar(Car car){
        int insertNum = carMapper.insert(car);
        return insertNum;
    }

    public int updateCar(Car car){
        int i = carMapper.updateById(car);
        return i;
    }

    public int deleteCar(Car car){
        Map<String,Object> condition = new HashMap<>();
        condition.put("name",car.getName());
        int effectRows = carMapper.deleteByMap(condition);
        return effectRows;
    }

}

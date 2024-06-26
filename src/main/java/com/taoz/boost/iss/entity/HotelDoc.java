package com.taoz.boost.iss.entity;

import lombok.Data;

/**
 * @author taozheng
 * @date 2023/11/14 - 21:44
 * @introduce:
 */
@Data
public class HotelDoc {

    private Long id;
    private String name;
    private String address;
    private Integer price;
    private Integer score;
    private String brand;
    private String city;
    private String starName;
    private String business;
    private String location;
    private String pic;

    public HotelDoc(Hotel hotel){
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.address = hotel.getAddress();
        this.price = hotel.getPrice();
        this.score = hotel.getScore();
        this.brand = hotel.getBrand();
        this.city = hotel.getCity();
        this.starName = hotel.getStarName();
        this.business = hotel.getArea();
        this.location = hotel.getLatitude() + "," + hotel.getLongitude();
        this.pic = hotel.getPic();
    }
}

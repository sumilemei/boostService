package com.taoz.boost.iss.controller;

import com.alibaba.fastjson.JSON;
import com.taoz.boost.config.ConfigUtils;
import com.taoz.boost.iss.entity.Hotel;
import com.taoz.boost.iss.entity.People;
import com.taoz.boost.iss.service.EsBaseService;
import com.taoz.boost.iss.service.EsSeniorService;
import com.taoz.boost.iss.service.HelloService;
import com.taoz.boost.iss.service.HotelService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: taoz
 * @date: 2023/2/26 19:39
 * @introduce:
 */
@RestController
@RequestMapping("/test")
public class TestHello {

    @Resource
    private HelloService helloService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private EsBaseService esBaseService;
    @Resource
    private EsSeniorService esSeniorService;
    @Resource
    private ConfigUtils configUtils;
    @Resource
    private HotelService hotelService;

    @RequestMapping("name")
    public String result(){
        String name = helloService.getName();
        System.out.println("这里是："+name);
        return "哈哈哈哈,"+name+"恭喜boost项目启动成功！！！";
    }

    @RequestMapping("esBase")
    public String esResult(){
        //esBaseService.createIndex("hotel",EsIndexMappingsConstant.TEST_MAPPING);
        //String test = esBaseService.existIndex("test");
        esBaseService.deleteByQueryDocument();
        //System.out.println(test);
        //esBaseService.deleteIndex("test");
        return "成功了";
    }

    @RequestMapping("esSenior")
    public void esSenior(){
        esSeniorService.boolSearch();
    }

    @RequestMapping("esDocument")
    public void esDocument(){
        esBaseService.bulkAddDocument();
    }

    @RequestMapping("config")
    public String getConfig(){
        return configUtils.getConfig("overtime");
    }

    @RequestMapping("redis")
    public People redisOp(){
        People p = new People("老虎",21,1,"北京",new String[]{"看书","听歌"},20000.3f);
        String people = JSON.toJSONString(p);
        stringRedisTemplate.opsForValue().set("people",people);
        String people1 = stringRedisTemplate.opsForValue().get("people");
        System.out.println(people1);
        People people2 = JSON.parseObject(people1, People.class);
        System.out.println(people2);

        stringRedisTemplate.opsForHash().put("user:100","name","大老虎");
        stringRedisTemplate.opsForHash().put("user:100","age","25");
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:100");
        Set<Object> keys = stringRedisTemplate.opsForHash().keys("user:100");
        List<Object> values = stringRedisTemplate.opsForHash().values("user:100");
        System.out.println("user:100: "+entries);
        System.out.println("keys:"+keys);
        System.out.println("values:"+values);

        return people2;
    }

    @RequestMapping("mp")
    public ResponseEntity<String> mpList(){
        List<Hotel> allHotel = hotelService.getAllHotel();
        Integer i = 0;
        if(allHotel != null && allHotel.size() > 0){
            for(Hotel hotel : allHotel){
                if(hotel.getName().contains("上海")){
                    i++;
                }
            }
        }
        return ResponseEntity.ok(i+"");
    }

    @RequestMapping("up")
    public ResponseEntity<String> mpUpdate(){
        hotelService.updateHotel();
        return ResponseEntity.ok("成功");
    }

    @RequestMapping("testMap")
    public ResponseEntity<String> testMap(){
        String test = helloService.getTest();
        return ResponseEntity.ok(test);
    }
}

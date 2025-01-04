package com.taoz.mp.controller;

import com.taoz.mp.service.MpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String getList(){
        return mpService.getCarList().get(0).getName();
    }


}

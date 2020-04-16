package com.medicine.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xhua
 * @Date 2020/4/16 14:38
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("hello")
    public String test(){
        return "hello world!";
    }
}

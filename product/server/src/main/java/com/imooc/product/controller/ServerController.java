package com.imooc.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Date: 2018/11/22
 */
@RestController
public class ServerController {


    @GetMapping("/msg")
    public String msg(){
        return "this is a message";
    }
}

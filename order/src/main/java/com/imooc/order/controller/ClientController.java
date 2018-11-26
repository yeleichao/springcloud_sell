package com.imooc.order.controller;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: TODO
 * @Date: 2018/11/22
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }


    @GetMapping("/getProductList")
    public String getProductList(){
       List<ProductInfo> list =  productClient.listForOrder(Arrays.asList("164103465734242707"));
       log.info("response={}", list);

       return "ok";
    }


    @GetMapping("/decreaseStock")
    public String prouductDecreaseStock(){
        productClient.decreaseStock(Arrays.asList(new CartDTO("164103465734242707", 3)));
        return "ok";
    }










    /*@Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        //1.第一种方式(直接使用restTemplate，url写死)
        *//*RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8082/msg", String.class);
        log.info("response={}", response);*//*

        //2.第二种方式（利用loadBalancerClient通过应用名获取url，然后在利用restTemplate）
        *//*RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance =  loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s", serviceInstance.getHost(),serviceInstance.getPort()+"/msg");
        String response = restTemplate.getForObject(url, String.class);*//*

        //3.第三种方式(使用@LoadBalanced注解，结合第二种方式）
        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        log.info("response={}", response);
        return response;
    }*/
}

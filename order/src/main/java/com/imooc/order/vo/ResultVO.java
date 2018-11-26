package com.imooc.order.vo;

import lombok.Data;

/**
 * @Description: TODO
 * @Date: 2018/11/21
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T Object;



}

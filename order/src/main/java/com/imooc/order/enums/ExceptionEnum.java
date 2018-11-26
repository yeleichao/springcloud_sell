package com.imooc.order.enums;

import lombok.Getter;

/**
 * @Description: TODO
 * @Date: 2018/11/21
 */
@Getter
public enum ExceptionEnum {

    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空"),
        ;

    private Integer code;

    private String message;


    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

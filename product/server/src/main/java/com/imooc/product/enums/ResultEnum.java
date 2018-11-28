package com.imooc.product.enums;

import lombok.Getter;

/**
 * @Description: TODO
 * @Date: 2018/11/26
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOE_EXIST(1,"商品不存在"),
    PRODUCT_STOCK_ERROR(2,"库存有误"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}

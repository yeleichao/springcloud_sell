package com.imooc.order.exception;

import com.imooc.order.enums.ExceptionEnum;

/**
 * @Description: TODO
 * @Date: 2018/11/21
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }
}

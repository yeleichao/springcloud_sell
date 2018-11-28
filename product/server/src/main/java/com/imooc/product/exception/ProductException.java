package com.imooc.product.exception;

import com.imooc.product.enums.ResultEnum;

/**
 * @Description: TODO
 * @Date: 2018/11/26
 */
public class ProductException extends  RuntimeException {

    private Integer code;

    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}

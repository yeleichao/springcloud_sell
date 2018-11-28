package com.imooc.product.VO;

import lombok.Data;

/**
 * @Description: 返回的具体对象
 * @Date: 2018/11/20
 */
@Data
public class ResultVO<T> {

    /**
     * 错误信息
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体的内容
     */
    private T data;
}

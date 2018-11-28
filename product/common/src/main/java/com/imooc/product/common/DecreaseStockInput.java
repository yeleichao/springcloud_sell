package com.imooc.product.common;

/**
 * @Description: 减库存入参
 * @Date: 2018/11/28
 */

public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}

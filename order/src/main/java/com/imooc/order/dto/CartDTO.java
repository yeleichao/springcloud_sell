package com.imooc.order.dto;

import lombok.Data;

/**
 * @Description: 购物车DTO
 * @Date: 2018/11/26
 */
@Data
public class CartDTO {

    /**
     * 商品的ID
     */
    private String productId;

    /**
     * 商品的数量
     */
    private Integer productQuantity;

    public CartDTO() {

    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}

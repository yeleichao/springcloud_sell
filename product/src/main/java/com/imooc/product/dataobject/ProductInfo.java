package com.imooc.product.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: TODO
 * @Date: s
 */
@Table(name = "product_info")
@Data
@Entity
public class ProductInfo {

    @Id
    private String productId;

    private BigDecimal productPrice;

    private String productName;

    private Integer productStock;//库存

    private String productDescription;//描述

    private String productIcon;//小图

    private Integer productStatus;//状态 0正常 1下架

    private Integer categoryType;//类目编号

    private Date createTime;

    private Date updateTime;
}

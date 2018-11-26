package com.imooc.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: TODO
 * @Date: 2018/11/21
 */
@Entity
@Data
@Table(name="order_detail")
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private BigDecimal productPrice;

    private Integer productQuantity;//商品数量

    private String productIcon;//商品小图

    private Date createTime;

    private Date updateTime;
}

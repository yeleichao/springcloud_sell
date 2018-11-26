package com.imooc.order.dto;

import com.imooc.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: TODO
 * @Date: 2018/11/21
 */
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;//订单总金额

    private Integer orderStatus;

    private Integer payStatus;

    private List<OrderDetail> orderDetails;
}

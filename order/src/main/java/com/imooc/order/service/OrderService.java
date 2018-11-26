package com.imooc.order.service;

import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dto.OrderDTO;

/**
 * @Description: TODO
 * @Date: 2018/11/21
 */
public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);
}

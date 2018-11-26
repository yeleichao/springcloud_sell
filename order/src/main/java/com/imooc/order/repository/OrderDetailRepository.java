package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: TODO
 * @Date: 2018/11/21
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}

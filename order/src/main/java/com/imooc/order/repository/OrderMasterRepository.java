package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: TODO
 * @Date: 2018/11/21
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}

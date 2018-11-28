package com.imooc.order.service.impl;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.repository.OrderDetailRepository;
import com.imooc.order.repository.OrderMasterRepository;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.keyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @Date: 2018/11/21
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = keyUtils.getUniqueKey();

        //查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetails().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());

        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);


        //计算总价
        BigDecimal orderAmount = BigDecimal.ZERO;
        for(OrderDetail orderDetail : orderDTO.getOrderDetails()){
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getProductId().equals(orderDetail.getProductId())){
                    orderAmount = productInfo.getProductPrice().
                            multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(keyUtils.getUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

         // 扣库存（调用商品服务）
        List<CartDTO> cartDTOList = orderDTO.getOrderDetails().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);


        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(keyUtils.getUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);//总金额
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);



        return orderDTO;
    }
}

package com.imooc.product.client;

import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description: TODO
 * @Date: 2018/11/26
 */

@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody  List<CartDTO> cartDTOList);

    static class ProductClientFallback implements ProductClient{

        @Override
        public List<ProductInfo> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<CartDTO> cartDTOList) {

        }
    }
}

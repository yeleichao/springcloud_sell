package com.imooc.product.service;

import com.imooc.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @Description: TODO
 * @Date: 2018/11/20
 */
public interface CategoryService {
    /**
     * 查询类目
     * @param list
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);
}

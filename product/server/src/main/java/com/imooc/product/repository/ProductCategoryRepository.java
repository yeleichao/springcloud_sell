package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description: TODO
 * @Date: 2018/11/20
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {

    /**
     * 查询类目
     * @param list
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);
}

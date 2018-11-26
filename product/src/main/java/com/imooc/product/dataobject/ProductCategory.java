package com.imooc.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description: TODO
 * @Date: 2018/11/20
 */
@Entity
@Data
@Table(name="product_category")
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;//类目名字

    private Integer categoryType;//类目编号

    private Date createTime;

    private Date updateTime;
}

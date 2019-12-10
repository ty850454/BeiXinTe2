package com.bxtsy.web.bean.product;

import com.bxtsy.web.dao.entity.ProductTypeDO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductTypeVO {

    private Long id;
    private String name;

    public static ProductTypeVO by(ProductTypeDO productTypeDO) {
        ProductTypeVO result = new ProductTypeVO();
        result.setId(productTypeDO.getId());
        result.setName(productTypeDO.getName());
        return result;
    }
}

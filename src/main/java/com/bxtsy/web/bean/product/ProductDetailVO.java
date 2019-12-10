package com.bxtsy.web.bean.product;

import com.bxtsy.web.dao.entity.ProductDO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailVO {

    private String name;
    private String img;
    private String content;
    private String typeName;
    private Long typeId;
    private String modelNumber;
    private String majorProduct ;

    public static ProductDetailVO by(ProductDO productDO) {
        ProductDetailVO result = new ProductDetailVO();
        result.setName(productDO.getName());
        result.setImg(productDO.getImg());
        result.setContent(productDO.getContent());
        result.setTypeId(productDO.getType() != null ? productDO.getType().getId(): null);
        result.setModelNumber(productDO.getModelNumber());
        result.setMajorProduct(productDO.getMajorProduct());
        return result;
    }

}

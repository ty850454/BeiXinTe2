package com.bxtsy.web.bean.product;

import com.bxtsy.web.dao.entity.ProductDO;
import com.bxtsy.web.utils.DateUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductListVO {

    private Long id;
    private String type;
    private String name;
    private String img;
    private String createTime;
    private String updateTime;


    public static ProductListVO by(ProductDO productDO) {
        ProductListVO result = new ProductListVO();
        result.setId(productDO.getId());
        result.setType(productDO.getType() != null ? productDO.getType().getName() : null);
        result.setImg(productDO.getImg());
        result.setName(productDO.getName());
        result.setCreateTime(DateUtil.DATE_TIME.format(productDO.getCreateTime()));
        result.setUpdateTime(DateUtil.DATE_TIME.format(productDO.getUpdateTime()));
        return result;
    }
}

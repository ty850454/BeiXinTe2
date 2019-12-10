package com.bxtsy.web.dao.entity;

import com.bxtsy.web.bean.product.ProductReq;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "t_product")
public class ProductDO extends BaseDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeId")
    private ProductTypeDO type;

    private String name;

    private String img;

    private String content;

    private String modelNumber;

    private String majorProduct ;

    public static ProductDO by(ProductReq req) {
        ProductDO result = new ProductDO();
        result.setName(req.getName());
        result.setImg(req.getImg());
        result.setContent(req.getContent());
        result.setModelNumber(req.getModelNumber());
        result.setMajorProduct(req.getMajorProduct());
        return result;
    }



}

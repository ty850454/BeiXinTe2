package com.bxtsy.web.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "t_product_type")
public class ProductTypeDO extends BaseDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public static ProductTypeDO by(String name) {
        ProductTypeDO productTypeDO = new ProductTypeDO();
        productTypeDO.name = name;
        return productTypeDO;
    }
}

package com.bxtsy.web.bean.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductReq {
    private String name;
    private String img;
    private String content;
    private Long type;
    private String modelNumber;
    private String majorProduct ;
}

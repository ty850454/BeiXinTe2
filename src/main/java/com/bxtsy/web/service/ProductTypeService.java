package com.bxtsy.web.service;

import com.bxtsy.web.bean.product.ProductTypeVO;
import com.bxtsy.web.dao.entity.DictDO;
import com.bxtsy.web.dao.entity.ProductTypeDO;
import com.bxtsy.web.dao.repository.ProductTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductTypeService {

    private ProductTypeRepository productTypeRepository;
    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public void saveOrUpdateOne(Long id, String name) {
        ProductTypeDO productTypeDO = null;
        if (id != null) {
            productTypeDO = productTypeRepository.findById(id).orElse(null);
        }
        if (StringUtils.isEmpty(name)) {
            name = "";
        }
        if (productTypeDO == null) {
            productTypeDO = ProductTypeDO.by(name);
        } else {
            productTypeDO.setName(name);
        }
        productTypeRepository.save(productTypeDO);
    }

    public List<ProductTypeVO> getAll() {
        return productTypeRepository.findAll().stream().map(ProductTypeVO::by).collect(Collectors.toList());
    }
}

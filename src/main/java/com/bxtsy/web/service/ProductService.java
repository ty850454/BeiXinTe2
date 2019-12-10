package com.bxtsy.web.service;

import com.bxtsy.web.bean.HttpPageParam;
import com.bxtsy.web.bean.PageDTO;
import com.bxtsy.web.bean.product.ProductDetailVO;
import com.bxtsy.web.bean.product.ProductListVO;
import com.bxtsy.web.bean.product.ProductReq;
import com.bxtsy.web.dao.entity.ProductDO;
import com.bxtsy.web.dao.entity.ProductTypeDO;
import com.bxtsy.web.dao.repository.ProductRepository;
import com.bxtsy.web.dao.repository.ProductTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductTypeRepository productTypeRepository;
    public ProductService(ProductRepository productRepository, ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
    }

    public PageDTO<ProductListVO> getAll(HttpPageParam page) {
        Page<ProductDO> pageDo = productRepository.findAllByOrderByCreateTimeDesc(PageRequest.of(page.getPage() - 1, page.getSize()));
        return PageDTO.of(pageDo.stream().map(ProductListVO::by).collect(Collectors.toList()), pageDo.getTotalElements());
    }

    @Transactional(readOnly = true)
    public ProductDetailVO getOne(Long id) {
        Optional<ProductDO> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            return null;
        }
        return ProductDetailVO.by(productOptional.get());
    }

    public void createOne(ProductReq req) {
        productRepository.save(ProductDO.by(req));
    }

    public void updateOne(Long id, ProductReq req) {
        ProductDO productDO = productRepository.findById(id).orElse(null);
        if (productDO == null) {
            return;
        }
        productDO.setName(req.getName());
        productDO.setImg(req.getImg());
        productDO.setContent(req.getContent());
        productDO.setMajorProduct(req.getMajorProduct());
        productDO.setModelNumber(req.getModelNumber());
        if (req.getType() != null) {
            ProductTypeDO productTypeDO = productTypeRepository.findById(req.getType()).orElse(null);
            productDO.setType(productTypeDO);
        } else {
            productDO.setType(null);
        }
        productRepository.save(productDO);
    }

    public void deleteOne(Long id) {
        productRepository.deleteById(id);
    }
}

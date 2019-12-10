package com.bxtsy.web.controller;


import com.bxtsy.web.bean.HttpResult;
import com.bxtsy.web.service.ProductTypeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productType")
public class ProductTypeController {

    private ProductTypeService productTypeService;
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping
    public HttpResult<?> getAll() {
        return HttpResult.success(productTypeService.getAll());
    }

    @PostMapping
    public HttpResult<?> createOne(String name) {
        productTypeService.saveOrUpdateOne(null, name);
        return HttpResult.success();
    }

    @PutMapping("/{id}")
    public HttpResult<?> updateOne(@PathVariable Long id, String name) {
        productTypeService.saveOrUpdateOne(id, name);
        return HttpResult.success();
    }

}

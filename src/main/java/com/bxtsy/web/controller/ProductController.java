package com.bxtsy.web.controller;

import com.bxtsy.web.bean.HttpPageParam;
import com.bxtsy.web.bean.HttpResult;
import com.bxtsy.web.bean.product.ProductReq;
import com.bxtsy.web.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    private HttpResult<?> getAll(HttpPageParam page) {
        return HttpResult.success(productService.getAll(page));
    }

    @GetMapping(value = "/{id}", params = "detail")
    private HttpResult<?> getOneDetail(@PathVariable Long id) {
        return HttpResult.success(productService.getOne(id));
    }

    @PostMapping
    private HttpResult<?> createOne(@RequestBody ProductReq req) {
        productService.createOne(req);
        return HttpResult.success();
    }

    @PutMapping("/{id}")
    private HttpResult<?> updateOne(@PathVariable Long id, @RequestBody ProductReq req) {
        productService.updateOne(id, req);
        return HttpResult.success();
    }

    @DeleteMapping("/{id}")
    private HttpResult<?> deleteOne(@PathVariable Long id) {
        productService.deleteOne(id);
        return HttpResult.success();
    }

}

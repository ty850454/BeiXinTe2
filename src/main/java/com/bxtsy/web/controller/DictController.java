package com.bxtsy.web.controller;

import com.bxtsy.web.bean.HttpResult;
import com.bxtsy.web.service.DictService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dict")
public class DictController {

    private DictService dictService;
    public DictController(DictService dictService) {
        this.dictService = dictService;
    }

    @GetMapping("/{key}")
    public HttpResult<String> getOne(@PathVariable String key) {
        return HttpResult.success(dictService.getOne(key));
    }

    @PostMapping("/{key}")
    public HttpResult<?> getOne(@PathVariable String key, @RequestParam String value) {
        dictService.saveOrUpdateOne(key, value);
        return HttpResult.success();
    }


}

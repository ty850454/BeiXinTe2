package com.bxtsy.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @PostMapping
    public String test() {
        return "{\n" +
                "\t\"xiezhen_vip\": 1,\n" +
                "\t\"video_vip\": 1,\n" +
                "\t\"status\": \"20000\",\n" +
                "\t\"type\": \"success\"\n" +
                "}";
    }

}

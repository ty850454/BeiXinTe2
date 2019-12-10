package com.bxtsy.web.bean;

import lombok.Getter;

@Getter
public enum HttpCode {
    SUCCESS("success"),ERROR("error");


    private String code;

    HttpCode(String code) {
        this.code = code;
    }
}

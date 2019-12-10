package com.bxtsy.web.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HttpResult<T> {


    private String code;
    private String msg;
    private T data;

    public HttpResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static HttpResult<?> success() {
        return new HttpResult<>(HttpCode.SUCCESS.getCode(), null, null);
    }

    public static <T> HttpResult<List<T>> success(PageDTO<T> date) {
        return new HttpPageResult<>(HttpCode.SUCCESS.getCode(), null, date.getDate(), date.getTotal());
    }

    public static <T> HttpResult<T> success(T date) {
        return new HttpResult<>(HttpCode.SUCCESS.getCode(), null, date);
    }

}

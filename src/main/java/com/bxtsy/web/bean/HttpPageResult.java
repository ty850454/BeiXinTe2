package com.bxtsy.web.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HttpPageResult<T> extends HttpResult<List<T>> {

    private long total;

    public HttpPageResult(String code, String msg, List<T> data, long total) {
        super(code, msg, data);
        this.total = total;
    }

    public static <T> HttpPageResult<T> success(List<T> date, long total) {
        return new HttpPageResult<>(HttpCode.SUCCESS.getCode(), null, date, total);
    }

}

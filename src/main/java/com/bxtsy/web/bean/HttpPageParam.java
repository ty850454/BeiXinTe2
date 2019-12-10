package com.bxtsy.web.bean;

import lombok.Setter;

@Setter
public class HttpPageParam {
    private Integer page;
    private Integer size;

    public Integer getPage() {
        return page == null ? 1 : page;
    }

    public Integer getSize() {
        return size == null ? 10 : size;
    }
}

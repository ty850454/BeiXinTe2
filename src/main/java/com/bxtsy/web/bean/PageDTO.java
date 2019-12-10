package com.bxtsy.web.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageDTO<T> {

    private List<T> date;
    private long total;

    public static <T> PageDTO<T> of(List<T> date, long total) {
        PageDTO<T> result = new PageDTO<>();
        result.date = date;
        result.total = total;
        return result;
    }





}

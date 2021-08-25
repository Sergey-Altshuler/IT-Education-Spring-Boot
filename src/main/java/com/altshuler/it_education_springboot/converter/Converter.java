package com.altshuler.it_education_springboot.converter;

import javax.servlet.http.HttpServletRequest;

public interface Converter<T> {
    T convert(HttpServletRequest request);
}

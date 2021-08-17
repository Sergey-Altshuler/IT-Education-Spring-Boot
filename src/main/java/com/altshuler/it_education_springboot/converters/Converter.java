package com.altshuler.it_education_springboot.converters;

import javax.servlet.http.HttpServletRequest;

public interface Converter<T> {
    T convert(HttpServletRequest request);
}

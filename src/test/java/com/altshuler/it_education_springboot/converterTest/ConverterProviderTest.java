package com.altshuler.it_education_springboot.converterTest;

import com.altshuler.it_education_springboot.converters.ConverterProvider;
import com.altshuler.it_education_springboot.model.Coach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class ConverterProviderTest {
    @Test
    void getConverter() {
        try {
            assertEquals(ConverterProvider.getConverterMap().get(Coach.class), ConverterProvider.getConverter(Coach.class));
        } catch (Exception e) {
            fail();
        }
    }
}

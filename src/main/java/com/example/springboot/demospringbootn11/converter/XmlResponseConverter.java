package com.example.springboot.demospringbootn11.converter;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class XmlResponseConverter implements ResponseConverter {
    @Override
    public void convert() {
        System.out.println("xml");
    }
}

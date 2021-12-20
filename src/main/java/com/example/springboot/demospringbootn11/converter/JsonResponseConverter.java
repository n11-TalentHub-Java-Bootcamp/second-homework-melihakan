package com.example.springboot.demospringbootn11.converter;

import org.springframework.stereotype.Component;

@Component
public class JsonResponseConverter implements ResponseConverter {
    @Override
    public void convert() {
        System.out.println("json");
    }
}

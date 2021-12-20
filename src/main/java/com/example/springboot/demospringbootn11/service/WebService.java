package com.example.springboot.demospringbootn11.service;

import com.example.springboot.demospringbootn11.converter.ResponseConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebService {

    @Autowired
    private ResponseConverter responseConverter;



    public void convertResponse() {
        responseConverter.convert();
    }

}

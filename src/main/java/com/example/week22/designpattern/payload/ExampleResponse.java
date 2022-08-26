package com.example.week22.designpattern.payload;

import lombok.Data;

import java.util.Map;

@Data
public class ExampleResponse {
    private Map<String, String> singleton;
    private Map<String, String> factoryMethod;
}

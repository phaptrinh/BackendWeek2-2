package com.example.week22.designpartten.payload;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ExampleResponse {
    private Map<String, String> singleton;
    private Map<String, String> factoryMethod;
}

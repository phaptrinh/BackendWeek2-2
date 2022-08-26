package com.example.week22.designpattern.controller;

import com.example.week22.designpattern.constant.ComputerType;
import com.example.week22.designpattern.factoryclass.ComputerFactory;
import com.example.week22.designpattern.payload.ExampleResponse;
import com.example.week22.designpattern.superclass.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/factory-method")
public class FactoryMethodController {
    @Autowired
    ComputerFactory computerFactory;

    @GetMapping("/{type}")
    ResponseEntity<?> getMethod(@PathVariable String type) {
        try {
            Computer computer = computerFactory.getComputer(ComputerType.valueOf(type.toUpperCase()));
            ExampleResponse response = new ExampleResponse();
            Map<String, String> singletonMap = new HashMap<>();
            singletonMap.put("computerFactory.toString()", computerFactory.toString());
            response.setSingleton(singletonMap);
            Map<String, String> factoryMap = new HashMap<>();
            factoryMap.put("computer.getClass()", computer.getClass().toString());
            factoryMap.put("computer.getType()", computer.getType());
            response.setFactoryMethod(factoryMap);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid computer type");
        }
    }
}

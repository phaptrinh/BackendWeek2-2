package com.example.week22.designpattern.subclass;

import com.example.week22.designpattern.superclass.Computer;

public class PC implements Computer {
    @Override
    public String getType() {
        return "PC";
    }
}

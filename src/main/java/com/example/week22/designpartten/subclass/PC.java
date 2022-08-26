package com.example.week22.designpartten.subclass;

import com.example.week22.designpartten.superclass.Computer;

public class PC implements Computer {
    @Override
    public String getType() {
        return "PC";
    }
}

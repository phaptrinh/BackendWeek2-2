package com.example.week22.designpartten.subclass;

import com.example.week22.designpartten.superclass.Computer;

public class Server implements Computer {

    @Override
    public String getType() {
        return "Server";
    }
}

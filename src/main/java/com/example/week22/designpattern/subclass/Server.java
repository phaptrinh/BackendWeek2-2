package com.example.week22.designpattern.subclass;

import com.example.week22.designpattern.superclass.Computer;

public class Server implements Computer {

    @Override
    public String getType() {
        return "Server";
    }
}

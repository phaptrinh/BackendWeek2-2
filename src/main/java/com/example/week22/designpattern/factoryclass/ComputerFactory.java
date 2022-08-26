package com.example.week22.designpattern.factoryclass;

import com.example.week22.designpattern.constant.ComputerType;
import com.example.week22.designpattern.subclass.PC;
import com.example.week22.designpattern.subclass.Server;
import com.example.week22.designpattern.superclass.Computer;
import org.springframework.stereotype.Component;

@Component
public class ComputerFactory {

    public Computer getComputer(ComputerType computerType) {
        switch (computerType) {
            case PC:
                return new PC();
            case SERVER:
                return new Server();
            default:
                throw new IllegalArgumentException("Invalid computer type!");

        }
    }


}

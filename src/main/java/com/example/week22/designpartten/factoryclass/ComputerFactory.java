package com.example.week22.designpartten.factoryclass;

import com.example.week22.designpartten.constant.ComputerType;
import com.example.week22.designpartten.subclass.PC;
import com.example.week22.designpartten.subclass.Server;
import com.example.week22.designpartten.superclass.Computer;
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

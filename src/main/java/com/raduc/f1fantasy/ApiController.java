package com.raduc.f1fantasy;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ApiController {

    @Autowired
    private Calculator calculator;

    @RequestMapping( "/" )
    public String home() {
        return "Welcome to my F1 Fantasy Calculator";
    }

    @RequestMapping( "/drivers" )
    public String getDrivers() throws IOException, JSONException, InterruptedException {
        calculator.createData();
        return calculator.getTeam(108.1);
//        return calculator.getDrivers();
    }
}

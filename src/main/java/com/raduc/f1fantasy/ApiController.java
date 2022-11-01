package com.raduc.f1fantasy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping( "/" )
    public String getStockItem() {
        return "Welcome to my F1 Fantasy Calculator";
    }
}

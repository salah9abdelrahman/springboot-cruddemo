package com.salah.springboot.crud.controller;

import com.salah.springboot.crud.PropConfig.TestPropConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestPropConfig testPropConfig;

    @GetMapping({"/", ""})
    StringBuilder test() {
        StringBuilder stringBuilder = new StringBuilder(testPropConfig.getAProp()).append(" | ");
        stringBuilder.append(testPropConfig.getNum()).append(" | ");
        testPropConfig.getListProp().forEach(i -> stringBuilder.append(i).append(" | "));
        return stringBuilder;
    }

    @GetMapping("/can")
    String canIChangeProps(){
        return testPropConfig.getAProp();
    }
}

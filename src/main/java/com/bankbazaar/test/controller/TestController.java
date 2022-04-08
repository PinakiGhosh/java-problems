package com.bankbazaar.test.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankbazaar.test.model.TestModel1;
import com.bankbazaar.test.model.TestModel2;

@RestController
public class TestController {
    @GetMapping("/")
    public String index()
    {
        return "Hello World";
    }
    @GetMapping("/API1")
    public String getAPi1()
    {
        TestModel1 test1 = new TestModel1();
        return test1.getData();
    }

    @GetMapping("/API2")
    public String getAPi2()
    {
        TestModel2 test2 = new TestModel2("Data2");
        return test2.getData();
    }

}

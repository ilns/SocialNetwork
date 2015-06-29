package com.model;

import org.springframework.stereotype.Service;

/**
 * Created by volodymyr on 29/06/15.
 */
@Service
public class HelloService {
    public String sayHello(){
        return "Hello world";
    }
}

package com.example.spring2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer{
    public void compile(){
        System.out.println("Compiling bugs, but yes faster");
    }
}

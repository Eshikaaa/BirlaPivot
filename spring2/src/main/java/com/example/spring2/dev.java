package com.example.spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class dev {
    @Autowired  //field injection
//    @Qualifier("laptop")
    private Computer comp;         //can use laptop,comp

//    public dev(Laptop laptop){                 //constructor inj,instead of autowire
//        this.laptop=laptop;
//    }

//    @Autowired
//    public void setLaptop(Laptop laptop){
//    setter inj , need to use autowire here too
//        this.laptop=laptop;
//    }


    public void build(){
        comp.compile();
        System.out.println("working on proj");
    }
}

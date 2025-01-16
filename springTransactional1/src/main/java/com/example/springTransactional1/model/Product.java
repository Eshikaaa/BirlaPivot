package com.example.springTransactional1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="beanProduct")
@Getter
@Setter
public class Product {
@Id
    private int Id;
private String name;
private double price;

//    public int getId() {
//        return Id;
//    }
//
//    public void setId(int id) {
//        this.Id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public double getPrice() {
//        return price;
//    }
//    public void setPrice(double price) {
//        this.price = price;
//    }


}

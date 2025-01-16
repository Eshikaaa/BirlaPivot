package com.example.springTransactional1.repo;

import com.example.springTransactional1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}

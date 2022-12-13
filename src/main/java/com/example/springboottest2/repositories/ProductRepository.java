package com.example.springboottest2.repositories;

import com.example.springboottest2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product,Long> {
    List<Product> findByName(String name);


}

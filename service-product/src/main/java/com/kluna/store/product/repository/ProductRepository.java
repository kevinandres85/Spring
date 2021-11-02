package com.kluna.store.product.repository;


import com.kluna.store.product.entity.Category;
import com.kluna.store.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
     List<Product> findByCategory(Category category);
}

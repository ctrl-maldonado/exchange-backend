package com.example.exchange.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exchange.category.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
}

package com.onlineshop.dresses.repository;

import com.onlineshop.dresses.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository <Category, Long>{
}

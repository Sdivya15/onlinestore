package com.onlineshop.dresses.repository;

import com.onlineshop.dresses.model.Fabrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FabricRepository extends JpaRepository <Fabrics, Long> {
}

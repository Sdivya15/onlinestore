package com.onlineshop.dresses.repository;

import com.onlineshop.dresses.model.Dress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DressesRepository extends JpaRepository <Dress, Long>{

    // Filter by Category Type
    List<Dress> findByCategory_CategoryType(String categoryType);

    // Filter by Fabric Name
    List<Dress> findByFabric_Name(String fabricName);

    // Filter by Availability
    List<Dress> findByIsAvailableTrue();

    // Find dresses with a discount
    List<Dress> findByDiscountGreaterThan(Double discount);
}

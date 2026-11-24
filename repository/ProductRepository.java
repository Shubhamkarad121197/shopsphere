package com.shopsphere.shopsphere.repository;

import com.shopsphere.shopsphere.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}

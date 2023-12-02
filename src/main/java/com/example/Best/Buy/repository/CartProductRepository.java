package com.example.Best.Buy.repository;

import com.example.Best.Buy.domain.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct,Long> {
}

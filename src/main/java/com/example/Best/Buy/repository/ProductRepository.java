package com.example.Best.Buy.repository;

import com.example.Best.Buy.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "select * from product where name LIKE %:value%",nativeQuery = true)
    List<Product> findByName(@Param("value") String value);
//    List<Product> findProductSearchByName(@Param("value")String value);

}

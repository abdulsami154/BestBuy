package com.example.Best.Buy.repository;

import com.example.Best.Buy.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.sun.imageio.plugins.jpeg.JPEG.vendor;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "select * from product where name LIKE %:value%",nativeQuery = true)
    List<Product> findByName(@Param("value") String value);

    @Query(value = "select * from product where vendor_Id=IFNULL(:vendorId,vendor_Id)",nativeQuery = true)
    List<Product> findByVendor(@Param("vendorId") Long vendorId);

    @Query(value = "select * from product where id=:id",nativeQuery = true)
    Product findByIds(@Param("id") Long id);

    List<Product> findByCategoryId(Long id);


//    List<Product> findProductSearchByName(@Param("value")String value);

}

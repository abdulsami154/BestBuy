package com.example.Best.Buy.repository;

import com.example.Best.Buy.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {
    @Query(value = "Delete From order_details where id=:id",nativeQuery = true)
    public void deleteByOrderDetailId(@Param("id")Long id);
}

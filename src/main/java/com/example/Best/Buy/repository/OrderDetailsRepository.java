package com.example.Best.Buy.repository;

import com.example.Best.Buy.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {
    @Query(value = "Delete From order_details where id=:id",nativeQuery = true)
    public void deleteByOrderDetailId(@Param("id")Long id);

    @Query(value = "Select od.* from cart_product cp inner join order_details od on cp.id=od.cart_product_id where cart_id=:cartId And cp.is_active=True",nativeQuery = true)
    List<OrderDetails> getOrderDetailByCartId(@Param("cartId") Long cartId);

    OrderDetails findByCartProductId(Long id);
}

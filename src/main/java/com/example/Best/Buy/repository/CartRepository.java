package com.example.Best.Buy.repository;

import com.example.Best.Buy.domain.Cart;
import com.example.Best.Buy.domain.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query(value = "delete from cart where user_id=:id",nativeQuery = true)
    public void deleteByUserId(@Param("id")Long id);


    @Query(value = "select * from cart where id=:id",nativeQuery = true)
    Cart findByIds(@Param("id") Long id);
}

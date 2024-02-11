package com.example.Best.Buy.repository;

import com.example.Best.Buy.domain.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct,Long> {
    @Modifying
    @Query(value = "select * from cart_product where cart_id=:id and is_active=true",nativeQuery = true)
    List<CartProduct> findAllCartByid(@Param("id")Long id);
    @Query(value = "select * from cart_product where cart_id=:cartId And product_id=:productId",nativeQuery = true)
    List<CartProduct> findByMultipleIds(@Param("cartId") Long cartId,@Param("productId") Long productId);

    CartProduct findCartProductById(Long id);
}

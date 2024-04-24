package com.example.Best.Buy.repository;

import com.example.Best.Buy.domain.ConversionCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionCurrencyRepository extends JpaRepository<ConversionCurrency,Long> {

    @Query(value = "select * from conversion_currency where conversion_currency_id=:id",nativeQuery = true)
    ConversionCurrency findByConversionCurrency(@Param("id") Long id);
}

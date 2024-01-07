package com.example.Best.Buy.repository;

import com.example.Best.Buy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select * from user where id =:id",nativeQuery = true)
    User findByIds(@Param("id") Long id);
}

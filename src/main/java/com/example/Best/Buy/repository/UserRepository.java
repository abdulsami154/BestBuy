package com.example.Best.Buy.repository;

import com.example.Best.Buy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

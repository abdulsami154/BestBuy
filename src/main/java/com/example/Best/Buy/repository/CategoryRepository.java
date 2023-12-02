package com.example.Best.Buy.repository;

import com.example.Best.Buy.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}

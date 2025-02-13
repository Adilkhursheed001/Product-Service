package com.E_commerceBackend.E_commerceBackend.repository;

import com.E_commerceBackend.E_commerceBackend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


    Optional<Category> findById(Long CategoryId);
}

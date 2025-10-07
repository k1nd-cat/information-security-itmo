package com.k1ndcat.lab1.repository;

import com.k1ndcat.lab1.entity.Product;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@NonNullApi
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findByTitle(String title);

    Optional<Product> findByIdAndTitle(Integer id, String title);
}

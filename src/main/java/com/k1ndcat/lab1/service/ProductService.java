package com.k1ndcat.lab1.service;

import com.k1ndcat.lab1.dto.ProductResponse;
import com.k1ndcat.lab1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<ProductResponse> getProducts(Pageable pageable) {
        var products = productRepository.findAll(pageable);
        return products.map(ProductResponse::fromProduct);
    }
}

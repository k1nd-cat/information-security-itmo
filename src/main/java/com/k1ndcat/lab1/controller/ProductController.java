package com.k1ndcat.lab1.controller;

import com.k1ndcat.lab1.dto.ProductResponse;
import com.k1ndcat.lab1.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
@Tag(name = "Products", description = "Операции с товарами")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(
            summary = "Получить список товаров",
            description = "Возвращает пагинированный список товаров"
    )
    @GetMapping
    public Page<ProductResponse> getProducts(
            @Parameter(description = "Номер страницы (0..N)", example = "0")
            @RequestParam(value = "page", defaultValue = "0") int page,
            @Parameter(description = "Размер страницы", example = "10")
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Pageable pageableParams = PageRequest.of(page, size);
        return productService.getProducts(pageableParams);
    }
}

package com.k1ndcat.lab1.dto;

import com.k1ndcat.lab1.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "ProductResponse", description = "Информация о товаре")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    @Schema(description = "Уникальный идентификатор товара", example = "1", nullable = false)
    private Integer id;

    @Schema(description = "Название товара", example = "Умная лампочка", nullable = false)
    private String title;

    @Schema(description = "Описание товара", example = "Лампочка с управлением через Wi-Fi и поддержкой смартфонов")
    private String description;

    @Schema(description = "Цена товара в рублях", example = "1299.99", nullable = false)
    private Double price;

    public static ProductResponse fromProduct(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}

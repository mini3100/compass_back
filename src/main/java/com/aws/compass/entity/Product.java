package com.aws.compass.entity;

import com.aws.compass.dto.ProductRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private int productId;
    private String productName;
    private int productPrice;
    private int productPeriod;

    public ProductRespDto toProduct() {
        return ProductRespDto.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productPeriod(productPeriod)
                .build();
    }
}

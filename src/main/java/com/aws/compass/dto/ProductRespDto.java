package com.aws.compass.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRespDto {

    private int productId;
    private int academyId;
    private String productName;
    private int productPrice;
    private int productPeriod;
}

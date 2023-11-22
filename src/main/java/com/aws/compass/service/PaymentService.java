package com.aws.compass.service;

import com.aws.compass.dto.ProductRespDto;
import com.aws.compass.dto.PurchaseReqDto;
import com.aws.compass.entity.Academy;
import com.aws.compass.entity.Purchase;
import com.aws.compass.repository.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentMapper paymentMapper;

    public List<ProductRespDto> getProducts() {
        List<ProductRespDto> productRespDtos = new ArrayList<>();
        paymentMapper.getProducts().forEach(product -> {
            productRespDtos.add(product.toProduct());
        });
        return productRespDtos;
    }

    public boolean purchase(PurchaseReqDto purchaseReqDto) {
        return paymentMapper.savePurchase(purchaseReqDto.toPurchase()) > 0;
    }

    public List<Academy> getPurchaseAcademy() {
        return paymentMapper.getPurchaseAcademy();
    }
}

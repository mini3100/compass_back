package com.aws.compass.repository;

import com.aws.compass.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    public List<Product> getPayments();
}

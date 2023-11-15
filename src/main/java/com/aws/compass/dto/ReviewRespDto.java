package com.aws.compass.dto;

import com.aws.compass.entity.Review;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ReviewRespDto {
    List<Review> reviewList;
}

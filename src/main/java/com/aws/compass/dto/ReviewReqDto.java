package com.aws.compass.dto;

import com.aws.compass.entity.Review;
import lombok.Data;

@Data
public class ReviewReqDto {
    private int academyId;
    private int userId;
    private int score;
    private String reviewContent;

    public Review toReview(){
        return Review.builder()
                .ACADEMY_ID(academyId)
                .user_id(userId)
                .score(score)
                .review_content(reviewContent)
                .build();
    }
}

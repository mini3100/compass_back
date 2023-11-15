package com.aws.compass.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    private int review_id;
    @JsonProperty("ACADEMY_ID")
    private int ACADEMY_ID;
    private int user_id;
    private int score;
    private String review_content;
    private String nickname;
}

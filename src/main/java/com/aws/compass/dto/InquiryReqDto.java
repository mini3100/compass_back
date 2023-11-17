package com.aws.compass.dto;

import lombok.Data;

@Data
public class InquiryReqDto {
    private int userId;
    private int academyId;
    private  String inquiryTitle;
    private String inquiryContent;
    private String answer;


}

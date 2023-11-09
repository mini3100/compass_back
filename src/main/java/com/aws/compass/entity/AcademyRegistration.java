package com.aws.compass.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcademyRegistration {
    private int academyRegistrationId;
    private String acaAsnum;
    private String acaNm;
    private String admstZoneNm;
    private String atptOfcdcScCode;
    private String match;
    private int userId;
    private String businessRegistrationFile;
    private String idFile;
    private String operationRegistrationFile;
}

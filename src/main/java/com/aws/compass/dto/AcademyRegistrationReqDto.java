package com.aws.compass.dto;

import com.aws.compass.entity.AcademyRegistration;
import lombok.Builder;
import lombok.Data;

@Data
public class AcademyRegistrationReqDto {
    private String acaAsnum;
    private String acaNm;
    private String admstZoneNm;
    private String atptOfcdcScCode;
    private String match;
    private int userId;
    private String businessRegistrationFile;
    private String idFile;
    private String operationRegistrationFile;

    public AcademyRegistration toAcademyRegist() {
        return AcademyRegistration.builder()
                .acaAsnum(acaAsnum)
                .acaNm(acaNm)
                .admstZoneNm(admstZoneNm)
                .atptOfcdcScCode(atptOfcdcScCode)
                .match(match)
                .userId(userId)
                .businessRegistrationFile(businessRegistrationFile)
                .idFile(idFile)
                .operationRegistrationFile(operationRegistrationFile)
                .build();
    }
}

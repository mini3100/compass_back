package com.aws.compass.dto;

import com.aws.compass.entity.AcademyRegistration;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AcademyRegistrationReqDto {

    private int academyRegistrationId;
    private int acaAsnum;
    private String acaNm;
    private String admstZoneNm;
    private String atptOfcdcScCode;
    private int match;
    private int userId;
    private String businessRegistrationFile;
    private String idFile;
    private String operationRegistrationFile;

    public AcademyRegistration toAcademyRegist() {
        return AcademyRegistration.builder()
                .academyRegistrationId(academyRegistrationId)
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

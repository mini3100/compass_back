package com.aws.compass.entity;

import com.aws.compass.dto.AwaitingAcademiesRepDto;
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
    private String name;
    private String businessRegistrationFile;
    private String idFile;
    private String operationRegistrationFile;
    private int approvalStatus;

    public AwaitingAcademiesRepDto toAwaitingAcademiesDto() {
        return AwaitingAcademiesRepDto.builder()
                .academyRegistrationId(academyRegistrationId)
                .acaAsnum(acaAsnum)
                .admstZoneNm(admstZoneNm)
                .atptOfcdcScCode(atptOfcdcScCode)
                .match(match)
                .userId(userId)
                .name(name)
                .businessRegistrationFile(businessRegistrationFile)
                .idFile(idFile)
                .operationRegistrationFile(operationRegistrationFile)
                .build();
    }

}

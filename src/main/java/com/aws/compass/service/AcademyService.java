package com.aws.compass.service;

import com.aws.compass.dto.AcademyRegistrationReqDto;
import com.aws.compass.repository.AcademyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AcademyService {

    private final AcademyMapper academyMapper;

    public boolean academyRegist(AcademyRegistrationReqDto academyRegistrationReqDto) {
        System.out.println(academyRegistrationReqDto);
        return academyMapper.academyRegist(academyRegistrationReqDto.toAcademyRegist()) > 0;
    }
}

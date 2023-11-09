package com.aws.compass.service;

import com.aws.compass.dto.AcademyRegistrationReqDto;
import com.aws.compass.repository.AcademyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AcademyService {

    private final AcademyMapper academyMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean academyRegist(AcademyRegistrationReqDto academyRegistrationReqDto) {
        System.out.println("service:" + academyRegistrationReqDto);
        return academyMapper.academyRegist(academyRegistrationReqDto.toAcademyRegist()) > 0;
    }
}

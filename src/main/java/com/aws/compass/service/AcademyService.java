package com.aws.compass.service;

import com.aws.compass.dto.AcademyRegistrationReqDto;
import com.aws.compass.entity.AcademyRegistration;
import com.aws.compass.exception.AcademyException;
import com.aws.compass.repository.AcademyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AcademyService {

    private final AcademyMapper academyMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean academyRegist(AcademyRegistrationReqDto academyRegistrationReqDto) {
        AcademyRegistration academyRegistration = academyRegistrationReqDto.toAcademyRegist();

        System.out.println("service:" + academyRegistration);

        int errorCode = academyMapper.academyDuplicate(academyRegistration);
        System.out.println(errorCode);
        if(errorCode > 0) {
            throw new AcademyException("이미 등록된 학원입니다.");
        }
        return academyMapper.academyRegist(academyRegistration) > 0;
    }
}

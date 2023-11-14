package com.aws.compass.service;

import com.aws.compass.dto.*;
import com.aws.compass.entity.Academy;
import com.aws.compass.entity.AcademyRegistration;
import com.aws.compass.exception.AcademyException;
import com.aws.compass.repository.AcademyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(rollbackFor = Exception.class)
    public boolean updateAcademyRegist(int academyRegistrationId, AcademyRegistrationReqDto academyRegistrationReqDto) {
        AcademyRegistration academyRegistration = academyRegistrationReqDto.toAcademyRegist();
        academyRegistration.setAcademyRegistrationId(academyRegistrationId);

        return academyMapper.updateAcademyRegist(academyRegistration) > 0;
    }

    public AcademyInfoRespDto getAcademies(SearchAcademysReqDto searchAcademysReqDto) {
        int listTotalCount = academyMapper.getListTotalCount(searchAcademysReqDto.toVo());
        List<Academy> academies = academyMapper.getAcademies(searchAcademysReqDto.toVo());
        return new AcademyListRespDto(listTotalCount, academies);
    }

    public Academy getAcademy(SearchAcademysReqDto searchAcademysReqDto) {
        return academyMapper.getAcademy(searchAcademysReqDto);
    }

    public MyAcademiesRespDto getAppliedAcademies(int userId, int page) {
        int index = (page - 1) * 5;

        List<AcademyRegistration> academyRegistrations = academyMapper.getAppliedAcademyRegistrations(userId, index);
        int listTotalCount = academyMapper.getAppliedAcademyCount(userId);

        return new MyAcademiesRespDto(academyRegistrations, listTotalCount);
    }
}
















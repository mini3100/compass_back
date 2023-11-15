package com.aws.compass.service;

import com.aws.compass.dto.AcademyInfoRespDto;
import com.aws.compass.dto.AcademyListRespDto;
import com.aws.compass.dto.AcademyRegistrationReqDto;
import com.aws.compass.dto.SearchAcademysReqDto;
import com.aws.compass.entity.Academy;
import com.aws.compass.entity.AcademyInfo;
import com.aws.compass.entity.AcademyRegistration;
import com.aws.compass.entity.ClassInfo;
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

    public AcademyListRespDto getAcademies(SearchAcademysReqDto searchAcademysReqDto) {
        int listTotalCount = academyMapper.getListTotalCount(searchAcademysReqDto.toVo());
        List<Academy> academies = academyMapper.getAcademies(searchAcademysReqDto.toVo());
        return new AcademyListRespDto(listTotalCount, academies);
    }

    public AcademyInfoRespDto getAcademy(int ACADEMY_ID) {
        Academy academy = academyMapper.getAcademy(ACADEMY_ID);
        AcademyInfo academyInfo  = academyMapper.getAcademyInfo(ACADEMY_ID);
        List<String> convenienceInfo = academyMapper.getConvenienceInfo(ACADEMY_ID);
        List<String> ageRange = academyMapper.getAgeRange(ACADEMY_ID);
        List<ClassInfo> classInfo = academyMapper.getClassInfo(ACADEMY_ID);
        System.out.println(classInfo);
        return new AcademyInfoRespDto(academy, academyInfo, convenienceInfo, ageRange, classInfo);
    }
}
















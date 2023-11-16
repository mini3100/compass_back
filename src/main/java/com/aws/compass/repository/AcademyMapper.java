package com.aws.compass.repository;

import com.aws.compass.dto.SearchAcademysReqDto;
import com.aws.compass.entity.*;
import com.aws.compass.vo.AcademySearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcademyMapper {
    public int academyDuplicate(AcademyRegistration academyRegistration);
    public int academyRegist(AcademyRegistration academyRegistration);
    public int updateAcademyRegist(AcademyRegistration academyRegistration);
    public List<Academy> getAcademies(AcademySearchVo academySearchVo);
    public Academy getAcademy(int ACADEMY_ID);
    public AcademyInfo getAcademyInfo(int ACADEMY_ID);
    public List<String> getConvenienceInfo(int ACADEMY_ID);
    public List<String> getAgeRange(int ACADEMY_ID);
    public List<ClassInfo> getClassInfo(int ACADEMY_ID);
    public int getListTotalCount(AcademySearchVo academySearchVo);
    public List<AcademyRegistration> getAppliedAcademyRegistrations(int userId, int index);
    public int getAppliedAcademyCount(int userId);
    public List<AcademyRegistration> getMyAcademyRegistrations(int userId, int index);
    public int getMyAcademyCount(int userId);
    public List<Review> getAcademyReviews(int academyId);
    public int updateAcademyInfo(AcademyInfo academyInfo);
}

package com.aws.compass.repository;

import com.aws.compass.dto.SearchAcademysReqDto;
import com.aws.compass.entity.Academy;
import com.aws.compass.entity.AcademyInfo;
import com.aws.compass.entity.AcademyRegistration;
import com.aws.compass.entity.ClassInfo;
import com.aws.compass.vo.AcademySearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcademyMapper {
    public int academyDuplicate(AcademyRegistration academyRegistration);
    public int academyRegist(AcademyRegistration academyRegistration);
    public List<Academy> getAcademies(AcademySearchVo academySearchVo);
    public Academy getAcademy(int ACADEMY_ID);
    public AcademyInfo getAcademyInfo(int ACADEMY_ID);
    public List<String> getConvenienceInfo(int ACADEMY_ID);
    public List<String> getAgeRange(int ACADEMY_ID);
    public List<ClassInfo> getClassInfo(int ACADEMY_ID);
    public int getListTotalCount(AcademySearchVo academySearchVo);

}

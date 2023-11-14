package com.aws.compass.repository;

import com.aws.compass.entity.Academy;
import com.aws.compass.entity.AcademyRegistration;
import com.aws.compass.vo.AcademySearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcademyMapper {
    public int academyDuplicate(AcademyRegistration academyRegistration);
    public int academyRegist(AcademyRegistration academyRegistration);
    public int updateAcademyRegist(AcademyRegistration academyRegistration);
    public List<Academy> getAcademies(AcademySearchVo academySearchVo);
    public int getListTotalCount(AcademySearchVo academySearchVo);
    public List<AcademyRegistration> getAppliedAcademyRegistrations(int userId, int index);
    public int getAppliedAcademyCount(int userId);
}

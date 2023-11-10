package com.aws.compass.repository;

import com.aws.compass.entity.Academy;
import com.aws.compass.entity.AcademyRegistration;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcademyMapper {
    public int academyDuplicate(AcademyRegistration academyRegistration);
    public int academyRegist(AcademyRegistration academyRegistration);
}

package com.aws.compass.repository;

import com.aws.compass.entity.AcademyRegistration;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AcademyMapper {
    public int academyRegist(AcademyRegistration academyRegistration);
}

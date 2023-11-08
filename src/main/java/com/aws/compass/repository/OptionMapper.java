package com.aws.compass.repository;

<<<<<<< HEAD
import com.aws.compass.entity.AdministrativeDistrict;
=======
import com.aws.compass.entity.AcademyRegistration;
>>>>>>> main
import com.aws.compass.entity.EducationOffice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionMapper {
    public List<EducationOffice> getEducationOfficeList();
<<<<<<< HEAD
    public List<AdministrativeDistrict> getAdministrativeDistrictList();
=======

>>>>>>> main
}

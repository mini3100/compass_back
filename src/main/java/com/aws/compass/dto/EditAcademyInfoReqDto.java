package com.aws.compass.dto;

import com.aws.compass.entity.Academy;
import com.aws.compass.entity.AcademyInfo;
import com.aws.compass.entity.ClassInfo;
import lombok.Data;

import java.util.List;

@Data
public class EditAcademyInfoReqDto {
    private AcademyInfo academyInfo;
    private List<String> convenienceInfo;
    private List<String> ageRange;
    private List<ClassInfo> classInfo;
}

package com.aws.compass.dto;

import com.aws.compass.entity.Academy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class AcademyInfoRespDto {
    private int listTotalCount;
    private List<Academy> academies;
}

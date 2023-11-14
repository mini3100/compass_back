package com.aws.compass.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcademySearchVo {
    private String atptOfcdcScCode;
    private String admstZoneNm;
    private String acaAsnum;
    private String acaNm;
    private String realmScNm;
    private String leOrdNm;
    private String leCrseNm;
//    private List<String> convenienceIds;
//    private int convenienceCount;
    private int index;
    private int pSize;
}

package com.aws.compass.service;

import com.aws.compass.dto.EducationOfficeRespDto;
import com.aws.compass.repository.OptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionService {
    private final OptionMapper optionMapper;

    public List<EducationOfficeRespDto> getEducationOfficeList() {
        List<EducationOfficeRespDto> educationOfficeRespDtos = new ArrayList<>();
        optionMapper.getEducationOfficeList().forEach(educationOffice -> educationOfficeRespDtos.add(educationOffice.toEducationOfficeDto()));
        return educationOfficeRespDtos;
    }
}

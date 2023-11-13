package com.aws.compass.controller;

import com.aws.compass.aop.annotation.ValidAop;
import com.aws.compass.dto.AcademyRegistrationReqDto;
import com.aws.compass.dto.SearchAcademysReqDto;
import com.aws.compass.service.AcademyService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AcademyController {

    private final AcademyService academyService;

    @GetMapping("/api/academies")
    public ResponseEntity<?> getAcademy(SearchAcademysReqDto searchAcademysReqDto) {
        System.out.println(searchAcademysReqDto);
        return ResponseEntity.ok(academyService.getAcademies(searchAcademysReqDto));
    }

    @ValidAop
    @PostMapping("/api/academy")
    public ResponseEntity getAcademyRegist(@Valid @RequestBody AcademyRegistrationReqDto academyRegistrationReqDto, BindingResult bindingResult) {
        System.out.println(academyRegistrationReqDto);
        return ResponseEntity.ok(academyService.academyRegist(academyRegistrationReqDto));
    }
}

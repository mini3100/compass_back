package com.aws.compass.controller;

import com.aws.compass.api.annotation.ValidAop;
import com.aws.compass.dto.AcademyRegistrationReqDto;
import com.aws.compass.service.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AcademyRegistrationController {

    private final AcademyService academyService;

    @ValidAop
    @PostMapping("/api/academy")
    public ResponseEntity getAcademyRegist(@Valid @RequestBody AcademyRegistrationReqDto academyRegistrationReqDto, BindingResult bindingResult) {
        System.out.println(academyRegistrationReqDto);
        return ResponseEntity.ok(academyService.academyRegist(academyRegistrationReqDto));
    }
}

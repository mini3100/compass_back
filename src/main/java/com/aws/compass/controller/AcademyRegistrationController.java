package com.aws.compass.controller;

import com.aws.compass.dto.AcademyRegistrationReqDto;
import com.aws.compass.service.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AcademyRegistrationController {

    private final AcademyService academyService;

    @PostMapping("/api/academy")
    public ResponseEntity getAcademyRegist(@RequestBody AcademyRegistrationReqDto academyRegistrationReqDto) {

        return ResponseEntity.ok(academyService.academyRegist(academyRegistrationReqDto));
    }
}

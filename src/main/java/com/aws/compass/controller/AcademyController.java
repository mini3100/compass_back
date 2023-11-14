package com.aws.compass.controller;

import com.aws.compass.aop.annotation.ValidAop;
import com.aws.compass.dto.AcademyRegistrationReqDto;
import com.aws.compass.dto.SearchAcademysReqDto;
import com.aws.compass.service.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getAcademyRegist(@Valid @RequestBody AcademyRegistrationReqDto academyRegistrationReqDto, BindingResult bindingResult) {
        return ResponseEntity.ok(academyService.academyRegist(academyRegistrationReqDto));
    }

    @ValidAop
    @PutMapping("/api/academy/{academyRegistrationId}")
    public ResponseEntity<?> updateAcademyRegist(@PathVariable int academyRegistrationId, @Valid @RequestBody AcademyRegistrationReqDto academyRegistrationReqDto, BindingResult bindingResult) {
        return ResponseEntity.ok(academyService.updateAcademyRegist(academyRegistrationId, academyRegistrationReqDto));
    }


    @GetMapping("/api/academies/{userId}/{page}")
    public ResponseEntity<?> getAppliedAcademies(@PathVariable int userId, @PathVariable int page) {
        return ResponseEntity.ok(academyService.getAppliedAcademies(userId, page));
    }
}

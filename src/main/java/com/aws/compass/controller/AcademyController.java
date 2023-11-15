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

    //학원 전체 리스트 가져오기
    @GetMapping("/api/academies")
    public ResponseEntity<?> getAcademies(SearchAcademysReqDto searchAcademysReqDto) {
        return ResponseEntity.ok(academyService.getAcademies(searchAcademysReqDto));
    }

    //학원 정보 가져오기 (단건)
    @GetMapping("/api/academy")
    public ResponseEntity<?> getAcademy(SearchAcademysReqDto searchAcademysReqDto) {
        return ResponseEntity.ok(academyService.getAcademy(searchAcademysReqDto.getACADEMY_ID()));
    }

    //학원 등록하기
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

    @GetMapping("/api/academies/applied/{userId}/{page}")
    public ResponseEntity<?> getAppliedAcademies(@PathVariable int userId, @PathVariable int page) {
        return ResponseEntity.ok(academyService.getAppliedAcademies(userId, page));
    }

    @GetMapping("/api/academies/{userId}/{page}")
    public ResponseEntity<?> getMyAcademies(@PathVariable int userId, @PathVariable int page) {
        return ResponseEntity.ok(academyService.getMyAcademies(userId, page));
    }

    //상세페이지 - 후기 가져오기
    @GetMapping("/api/academy/{academyId}/reviews")
    public ResponseEntity<?> getAcademyReviews(@PathVariable int academyId) {
        return ResponseEntity.ok(academyService.getAcademyReviews(academyId));
    }
}

package com.aws.compass.controller;

import com.aws.compass.dto.WriteInquiryReqDto;
import com.aws.compass.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService inquiryService;

    @PostMapping("/api/inquiry")
    public ResponseEntity<?> writeInquiry(@Valid @RequestBody WriteInquiryReqDto inquiryReqDto, BindingResult bindingResult) {
        return ResponseEntity.ok(inquiryService.writeInquiry(inquiryReqDto));
    }

}

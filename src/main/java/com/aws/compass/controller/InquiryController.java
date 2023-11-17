package com.aws.compass.controller;

import com.aws.compass.dto.InquiryReqDto;
import com.aws.compass.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService inquiryService;

    public ResponseEntity<?> writeInquiry(InquiryReqDto inquiryReqDto) {
        return ResponseEntity.ok(null);
    }
}

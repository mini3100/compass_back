package com.aws.compass.controller;

import com.aws.compass.dto.ApprovalAcademyReqDto;
import com.aws.compass.dto.DisapprovalReqDto;
import com.aws.compass.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/api/admin/academies/awaiting/{page}")
    public ResponseEntity<?> getAwaitingAcademies(@PathVariable int page) {
        return ResponseEntity.ok(adminService.getAwaitingAcademies(page));
    }

    @PutMapping("/api/admin/academy/approval")
    public ResponseEntity<?> approvalAcademy(@RequestBody ApprovalAcademyReqDto approvalAcademyReqDto) {
        return ResponseEntity.ok(adminService.approvalAcademy(approvalAcademyReqDto));
    }

    @PutMapping("/api/admin/academy/disapproval")
    public ResponseEntity<?> disapprovalAcademy(@RequestBody DisapprovalReqDto disapprovalReqDto) {
        return ResponseEntity.ok(adminService.disapprovalAcademy(disapprovalReqDto));
    }
}

package com.aws.compass.controller;

import com.aws.compass.aop.annotation.ValidAop;
import com.aws.compass.dto.AcademyLikeRespDto;
import com.aws.compass.dto.EditUserReqDto;
import com.aws.compass.dto.PrincipalRespDto;
import com.aws.compass.entity.User;
import com.aws.compass.security.PrincipalUser;
import com.aws.compass.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/api/account/principal")
    public ResponseEntity<?> getPrincipal() {
        PrincipalUser principalUser =
                (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principalUser.getUser();
        PrincipalRespDto principalRespDto = user.toPrincipalDto();
        return ResponseEntity.ok(principalRespDto);
    }

    @ValidAop
    @PutMapping("/api/account/user/{userId}")
    public ResponseEntity<?> editUser(@PathVariable int userId,
                                      @Valid @RequestBody EditUserReqDto editUserReqDto,
                                      BindingResult bindingResult) {
        return ResponseEntity.ok(accountService.updateUser(userId,editUserReqDto));
    }

    @PostMapping("/api/account/auth/email")
    public ResponseEntity<?> sendAuthenticationMail() {
        return ResponseEntity.ok(accountService.sendAuthMail());
    }

    @GetMapping("/api/account/auth/email")
    public ResponseEntity<?> authenticateMail (String token) {
        //주소의 토큰을 받고 유효한지 확인
        return ResponseEntity.ok(accountService.authenticateMail(token) ? "인증 완료" : "인증 실패");
    }

    @GetMapping("/api/account/like/{academyId}/{userId}")
    public ResponseEntity<?> getLikeState (@PathVariable int userId, @PathVariable int academyId) {
        System.out.println(academyId);
        return ResponseEntity.ok(accountService.getLikeState(userId, academyId));
    }

    @PostMapping("/api/account/like/{academyId}/{userId}")
    public ResponseEntity<?> setLike(@PathVariable int userId, @PathVariable int academyId) {
        return ResponseEntity.ok(accountService.setLike(userId, academyId));
    }

    @DeleteMapping("/api/account/like/{academyId}/{userId}")
    public ResponseEntity<?> cancelLike(@PathVariable int userId, @PathVariable int academyId) {
        return ResponseEntity.ok(accountService.cancelLike(userId, academyId));
    }

    @GetMapping("/api/account/mypage/like/count/{userId}")
    public ResponseEntity<?> getLikeCount(@PathVariable int userId) {
        return ResponseEntity.ok(accountService.getLikeCount(userId));
    }

    @GetMapping("/api/account/mypage/like/{userId}")
    public ResponseEntity<?> getLikeAcademies(@PathVariable int userId) {
        return ResponseEntity.ok(accountService.getLikeAcademy(userId));
    }

    @GetMapping("/api/account/info/like/count/{academyId}")
    public ResponseEntity<?> getLikeCountOfInfo(@PathVariable int academyId) {
        return ResponseEntity.ok(accountService.getLikeInfoCount(academyId));
    }
}

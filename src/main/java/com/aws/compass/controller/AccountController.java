package com.aws.compass.controller;

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

    @PutMapping("/api/account/user/{userId}")
    public ResponseEntity<?> editUser(@PathVariable int userId,
                                      @Valid @RequestBody EditUserReqDto editUserReqDto,
                                      BindingResult bindingResult) {
        return ResponseEntity.ok(accountService.updateUser(userId,editUserReqDto));
    }
}

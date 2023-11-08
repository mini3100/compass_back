package com.aws.compass.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
@Data
public class PrincipalRespDto { // 마이페이지에서 쓸 정보들 응답 dto

    @NotBlank
    private int userId;
    @NotBlank
    private String email;
    @NotBlank
    private String oauth2Id;
    @NotBlank
    private String name;
    @NotBlank
    private String nickname;
    @NotBlank
    private String phone;
    @NotBlank
    private String provider;
    @NotBlank
    private boolean enabled;
}

package com.aws.compass.service;

import com.aws.compass.dto.EditUserReqDto;
import com.aws.compass.entity.User;
import com.aws.compass.repository.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;

    public boolean updateUser(int userId, EditUserReqDto editUserReqDto) {
        User newUser = editUserReqDto.toUser();
        newUser.setUserId(userId);
        return accountMapper.updateUser(newUser) > 0;
    }
}

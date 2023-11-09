package com.aws.compass.repository;

import com.aws.compass.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    public int updateUser(User user);
    public User findUserByEmail(String email);
    public int updateEnabledToEmail(String email);
    public int checkDuplicateAndIdNot(User user);
}

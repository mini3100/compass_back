package com.aws.compass.repository;

import com.aws.compass.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    public int updateUser(User user);
}

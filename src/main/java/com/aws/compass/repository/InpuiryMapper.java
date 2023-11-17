package com.aws.compass.repository;


import com.aws.compass.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InpuiryMapper {
    public int saveInpuiry(Inquiry inquiry);
}

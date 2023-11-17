package com.aws.compass.service;

import com.aws.compass.dto.WriteInquiryReqDto;
import com.aws.compass.entity.Inquiry;
import com.aws.compass.repository.InpuiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InquiryService {
    private final InpuiryMapper inpuiryMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean writeInquiry(WriteInquiryReqDto inquiryReqDto) {
        Inquiry inquiry = inquiryReqDto.toInquiry();
        return inpuiryMapper.saveInpuiry(inquiry) > 0;
    }

}

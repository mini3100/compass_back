package com.aws.compass.service;

import com.aws.compass.dto.AwaitingAcademiesRepDto;
import com.aws.compass.dto.UserInquiriesRespDto;
import com.aws.compass.dto.WriteInquiryReqDto;
import com.aws.compass.entity.AcademyRegistration;
import com.aws.compass.entity.Inquiry;
import com.aws.compass.repository.InpuiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InquiryService {
    private final InpuiryMapper inpuiryMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean writeInquiry(WriteInquiryReqDto inquiryReqDto) {
        Inquiry inquiry = inquiryReqDto.toInquiry();
        System.out.println(inquiry);
        return inpuiryMapper.saveInpuiry(inquiry) > 0;
    }

    public UserInquiriesRespDto getUserInquiries(int userId, int page) {
        int index = (page - 1) * 5;

        List<Inquiry> inquiries = inpuiryMapper.getUserInquiries(userId, index);
        int listTotalCount = inpuiryMapper.getUserInquiriesCount(userId);

        return new UserInquiriesRespDto(inquiries, listTotalCount);
    }


}

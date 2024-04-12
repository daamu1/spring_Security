package com.eazybytes.payload.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResDTO {
    private int noticeId;
    private String noticeSummary;
    private String noticeDetails;
    private Date noticeBegDate;
    private Date noticeEndDate;
}
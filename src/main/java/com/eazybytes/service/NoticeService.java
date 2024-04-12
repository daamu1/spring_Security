package com.eazybytes.service;

import com.eazybytes.payload.response.NoticeResDTO;

import java.util.List;

public interface NoticeService {
    List<NoticeResDTO> findAllActiveNotices();
}

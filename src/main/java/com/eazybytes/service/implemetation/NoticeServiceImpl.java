package com.eazybytes.service.implemetation;

import com.eazybytes.payload.response.NoticeResDTO;
import com.eazybytes.repository.NoticeRepository;
import com.eazybytes.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    public List<NoticeResDTO> findAllActiveNotices() {
        return noticeRepository.findAllActiveNotices().stream()
                .map(notice -> new NoticeResDTO(
                        notice.getNoticeId(),
                        notice.getNoticeSummary(),
                        notice.getNoticeDetails(),
                        notice.getNoticeBegDate(),
                        notice.getNoticeEndDate()
                )).collect(Collectors.toList());
    }
}

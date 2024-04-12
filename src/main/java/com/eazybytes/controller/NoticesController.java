package com.eazybytes.controller;

import com.eazybytes.payload.response.NoticeResDTO;
import com.eazybytes.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notices")
    public ResponseEntity<List<NoticeResDTO>> getNotices() {
        List<NoticeResDTO> notices = noticeService.findAllActiveNotices();
        return Optional.ofNullable(notices)
                .filter(not -> !not.isEmpty())
                .map(not -> ResponseEntity.ok()
                        .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                        .body(not))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}

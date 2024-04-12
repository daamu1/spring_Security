package com.eazybytes.repository;

import com.eazybytes.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
	@Query("SELECT n FROM Notice n WHERE CURRENT_DATE() BETWEEN n.noticeBegDate AND n.noticeEndDate")
	List<Notice> findAllActiveNotices();
}

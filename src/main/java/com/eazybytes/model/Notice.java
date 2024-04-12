package com.eazybytes.model;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "notice_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "notice_id")
	private int noticeId;

	@Column(name = "notice_summary")
	private String noticeSummary;

	@Column(name = "notice_details")
	private String noticeDetails;

	@Temporal(TemporalType.DATE)
	@Column(name = "notice_beg_dt")
	private Date noticeBegDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "notice_end_dt")
	private Date noticeEndDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_dt")
	private Date createDt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_dt")
	private Date updateDt;
}

package com.eazybytes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {

	@Id
	@Column(name = "account_number", nullable = false)
	private long accountNumber;

	@Column(name = "customer_id", nullable = false)
	private int customerId;

	@Column(name = "account_type", nullable = false, length = 30)
	private String accountType;

	@Column(name = "branch_address", nullable = false, length = 255)
	private String branchAddress;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_dt", nullable = false)
	private Date createDt;

}

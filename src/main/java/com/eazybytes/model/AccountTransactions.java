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
@Table(name = "account_transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransactions {

	@Id
	@Column(name = "transaction_id", nullable = false)
	private String transactionId;

	@Column(name = "account_number", nullable = false)
	private long accountNumber;

	@Column(name = "customer_id", nullable = false)
	private int customerId;

	@Temporal(TemporalType.DATE)
	@Column(name = "transaction_dt", nullable = false)
	private Date transactionDt;

	@Column(name = "transaction_summary", nullable = false, length = 255)
	private String transactionSummary;

	@Column(name = "transaction_type", nullable = false, length = 30)
	private String transactionType;

	@Column(name = "transaction_amt", nullable = false)
	private int transactionAmt;

	@Column(name = "closing_balance", nullable = false)
	private int closingBalance;

	@Column(name = "create_dt", nullable = false)
	private Date createDt;
}

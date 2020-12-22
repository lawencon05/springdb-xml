package com.lawencon.springdb.service;

import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author lawencon05
 */
public class BaseServiceImpl {

	private TransactionTemplate transactionTemplate;

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

}

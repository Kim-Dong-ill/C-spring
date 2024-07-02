package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.example.demo.dao.ITransaction1Dao;
import com.example.demo.dao.ITransaction2Dao;

@Service
public class BuyTicketService implements IBuyTicketService{

	@Autowired
	ITransaction1Dao transaction1;
	
	@Autowired
	ITransaction2Dao transaction2;
	
	//트랜잭션
	@Autowired
	PlatformTransactionManager transactionManager;
	//트랜잭션
	@Autowired
	TransactionDefinition definition;
	
	@Override
	public int buy(String consumerId, int money, String error) {
		
		//트랜잭션
		TransactionStatus status = transactionManager.getTransaction(definition);
		
		try {
			transaction1.pay(consumerId, money);
			transaction2.pay(consumerId, money);
			
			//트랜잭션 실행부분
			transactionManager.commit(status);
			
			return 1;
		} catch (Exception e) {
			
			//트랜잭션 에러났을때 롤백하기
			transactionManager.rollback(status);
			return 0;
		}
	}
	
}

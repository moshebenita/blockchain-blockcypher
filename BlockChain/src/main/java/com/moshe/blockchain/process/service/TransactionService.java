package com.moshe.blockchain.process.service;

import com.moshe.blockchain.client.object.WalletObject;
import com.moshe.blockchain.db.entity.CurrencyType;

public interface TransactionService {
	
	public String buyToCustomer(WalletObject buyWallet,String toAddress, int amount) throws TransactionException;
	public int getBalanceToCustomer(String customerId);
	public int getBalanceBykey(String publicKey);
	

}

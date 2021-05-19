package com.moshe.blockchain.db.dao;

import com.moshe.blockchain.db.entity.CustomerWallet;

public interface WalletDao {
	
	public CustomerWallet getCustomerWalletByCustometId(Long customerId);

}

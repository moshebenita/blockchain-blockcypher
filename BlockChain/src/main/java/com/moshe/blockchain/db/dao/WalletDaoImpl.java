package com.moshe.blockchain.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moshe.blockchain.db.entity.CustomerWallet;
import com.moshe.blockchain.db.repository.WalletRepository;

@Service
public class WalletDaoImpl implements WalletDao {
	
	@Autowired
	private WalletRepository walletRepository;
	

	@Override
	public CustomerWallet getCustomerWalletByCustometId(Long customerId) {
		List<CustomerWallet> CustomerWalletList = walletRepository.findByCustomer(customerId);
		if(CustomerWalletList.isEmpty())
			throw new RuntimeException("not found wallet for the customer");
		return CustomerWalletList.get(0);
	}

}

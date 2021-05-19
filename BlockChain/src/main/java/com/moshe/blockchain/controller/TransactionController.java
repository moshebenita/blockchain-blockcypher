package com.moshe.blockchain.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moshe.blockchain.client.object.BuyObject;
import com.moshe.blockchain.client.object.WalletObject;
import com.moshe.blockchain.db.dao.WalletDao;
import com.moshe.blockchain.db.entity.AdminWallet;
import com.moshe.blockchain.db.entity.CustomerWallet;
import com.moshe.blockchain.db.repository.WalletAdminRepository;
import com.moshe.blockchain.db.repository.WalletRepository;
import com.moshe.blockchain.process.service.TransactionException;
import com.moshe.blockchain.process.service.TransactionService;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private WalletDao walletDao;
	
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private WalletAdminRepository walletAdminRepository;
	
	@GetMapping("/getBalance/{customerId}")
	public int getCustomer(@PathVariable("customerId") Long customerId) {
		Optional<CustomerWallet> val = walletRepository.findById(customerId);
		List<CustomerWallet> val2 = walletRepository.findByCustomer(customerId);
		if(val2.isEmpty())
			throw new RuntimeException("not found wallet for the customer");
		return transactionService.getBalanceBykey(walletDao.getCustomerWalletByCustometId(customerId).getAddress());
	}
	
	@PostMapping("/buy")
	public String buyToCustomer(@RequestBody BuyObject buyObject) throws TransactionException {
		List<AdminWallet> adminWallets = walletAdminRepository.findByCurrency(buyObject.getCurrencyType());
		if(adminWallets.isEmpty())
			throw new RuntimeException("not found admin wallet for this currency");
		transactionService.buyToCustomer(new WalletObject(adminWallets.get(0).getAddress(), adminWallets.get(0).getPublicKey(), adminWallets.get(0).getPrivateKey(), null)
				, findCustomerWallet(buyObject.getCustomerId()).getAddress(), buyObject.getAmount());
		return null;
		
	}
	
	private CustomerWallet findCustomerWallet(Long customerId) {
		List<CustomerWallet> CustomerWalletList = walletRepository.findByCustomer(customerId);
		if(CustomerWalletList.isEmpty())
			throw new RuntimeException("not found wallet for the customer");
		return CustomerWalletList.get(0);
	}
}

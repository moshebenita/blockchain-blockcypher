package com.moshe.blockchain.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moshe.blockchain.client.object.WalletObject;
import com.moshe.blockchain.db.dao.WalletDao;
import com.moshe.blockchain.db.entity.AdminWallet;
import com.moshe.blockchain.db.entity.CurrencyType;
import com.moshe.blockchain.db.entity.Customer;
import com.moshe.blockchain.db.entity.CustomerWallet;
import com.moshe.blockchain.db.repository.CustomerRepository;
import com.moshe.blockchain.db.repository.WalletAdminRepository;
import com.moshe.blockchain.db.repository.WalletRepository;
import com.moshe.blockchain.process.service.WalletService;

@RestController
@RequestMapping("api/wallet")
public class WalletController {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private WalletAdminRepository walletAdminRepository;
	
	@Autowired
	private WalletDao walletDao;
	


	@PostMapping("/addAdminWallet")
	public ResponseEntity createNewWallet(@RequestBody AdminWallet wallet) {
		walletAdminRepository.save(wallet);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PostMapping("/createWallet/{customerId}")
	public ResponseEntity createNewWallet(@PathVariable("customerId") Long customerId) {
		Optional<Customer> customerOptional = customerRepo.findById(customerId);
		if(customerOptional.isEmpty())
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		
		WalletObject wallet = walletService.createNewWallet();
		CustomerWallet customerWallet= new CustomerWallet(null,CurrencyType.TEST,
				wallet.getAddress(),wallet.getPublicKey(),wallet.getPrivateKey(),customerOptional.get());
		walletRepository.save(customerWallet);
		return new ResponseEntity(wallet.getAddress(),HttpStatus.CREATED);
	}
	
	@GetMapping("/getWallet/{customerId}")
	public CustomerWallet getCustomer(@PathVariable("customerId") Long customerId) {
		return walletDao.getCustomerWalletByCustometId(customerId);
	}
	
}

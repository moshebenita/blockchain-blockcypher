package com.moshe.blockchain.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moshe.blockchain.client.object.WalletObject;
import com.moshe.blockchain.db.entity.AdminWallet;
import com.moshe.blockchain.db.entity.CurrencyType;
import com.moshe.blockchain.db.entity.Customer;
import com.moshe.blockchain.db.entity.CustomerWallet;
import com.moshe.blockchain.db.repository.CustomerRepository;
import com.moshe.blockchain.db.repository.WalletAdminRepository;
import com.moshe.blockchain.db.repository.WalletRepository;
import com.moshe.blockchain.process.service.WalletService;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private WalletAdminRepository walletAdminRepository;
	
	private ObjectMapper om = new ObjectMapper();

	@PostMapping("/newCustomer")
	public ResponseEntity createNewCustomer(@RequestBody Customer customer) {
		customerRepo.save(customer);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getCustomer{customerId}")
	public ResponseEntity getCustomer(@PathVariable("customerId") Long customerId) {
		Optional<Customer> customer = customerRepo.findById(customerId);
		return customer.isEmpty() ? new ResponseEntity(HttpStatus.NOT_FOUND) :
			new ResponseEntity(customer.get() ,HttpStatus.OK);  
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer() {
		Iterable<Customer> iterable = customerRepo.findAll();
		return StreamSupport.stream(iterable.spliterator(), false)
	    .collect(Collectors.toList());
	}
}

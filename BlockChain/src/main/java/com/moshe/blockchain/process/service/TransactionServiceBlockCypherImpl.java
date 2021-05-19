package com.moshe.blockchain.process.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moshe.blockchain.client.object.Balance;
import com.moshe.blockchain.client.object.SignedTx;
import com.moshe.blockchain.client.object.ToSignTx;
import com.moshe.blockchain.client.object.WalletObject;
import com.moshe.blockchain.client.object.addresses.AddressesForTx;
import com.moshe.blockchain.client.object.addresses.Input;
import com.moshe.blockchain.client.object.addresses.Output;
import com.moshe.blockchain.security.SignServiceGoImpl;


@Service
public class TransactionServiceBlockCypherImpl implements TransactionService{


	@Value("${token:}")
	private String token;

	@Autowired
	SignServiceGoImpl signer;


	@Override
	public String buyToCustomer(WalletObject buyWallet,String toAddress, int amount) throws TransactionException {
		RestTemplate restTemplate = new RestTemplate();
		AddressesForTx addressesForTx = new AddressesForTx();
		List<Input> inputs = new ArrayList<>();
		inputs.add(new Input(Arrays.asList(buyWallet.getAddress())));
		addressesForTx.setInputs(inputs);
		List<Output> output = new ArrayList<Output>();
		output.add(new Output(Arrays.asList(toAddress), amount));
		addressesForTx.setOutputs(output);

		ToSignTx toSignTx = restTemplate.postForEntity("https://api.blockcypher.com/v1/bcy/test/txs/new"
				,addressesForTx,ToSignTx.class).getBody();

		List<String> signedList = new LinkedList<String>();
		List<String> pubKeysList = new LinkedList<String>();
		for(int i = 0; i < toSignTx.getTosign().size(); i++) {
			String signed = signer.signByKey(toSignTx.getTosign().get(i), buyWallet.getPrivateKey());
			signedList.add(signed);
			pubKeysList.add(buyWallet.getPublicKey());
		}
		SignedTx signedTx = new SignedTx(toSignTx.getTx(), toSignTx.getTosign(), signedList, pubKeysList);

		ResponseEntity<Object> val1 = restTemplate.postForEntity("https://api.blockcypher.com/v1/bcy/test/txs/send?token="+ token
				,signedTx,Object.class);

		ObjectMapper om = new ObjectMapper();
		try {
			System.err.println(om.writeValueAsString(val1));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int getBalanceToCustomer(String customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBalanceBykey(String publicKey) {
		RestTemplate restTemplate = new RestTemplate();
		Balance balance = restTemplate.getForEntity("https://api.blockcypher.com/v1/bcy/test/addrs/" + publicKey +"/balance"
				,Balance.class).getBody();
		return balance.getBalance();
	}


}

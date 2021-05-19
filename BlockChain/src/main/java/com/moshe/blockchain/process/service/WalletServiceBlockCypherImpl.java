package com.moshe.blockchain.process.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moshe.blockchain.client.object.WalletObject;

@Service
public class WalletServiceBlockCypherImpl implements WalletService {
	
	@Value("${token:}")
	private String token;

	@Override
	public WalletObject createNewWallet() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<WalletObject> val = restTemplate.postForEntity("https://api.blockcypher.com/v1/bcy/test/addrs?token=" + token
				,null,WalletObject.class);
		return val.getBody();
	}

	@Override
	public String genarateNewPublicKey(WalletObject walletObject) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

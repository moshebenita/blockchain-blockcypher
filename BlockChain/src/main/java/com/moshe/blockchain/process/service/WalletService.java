package com.moshe.blockchain.process.service;

import com.moshe.blockchain.client.object.WalletObject;

public interface WalletService {
	
	public WalletObject createNewWallet();
	public String genarateNewPublicKey(WalletObject walletObject);

}

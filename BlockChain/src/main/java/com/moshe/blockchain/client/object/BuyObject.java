package com.moshe.blockchain.client.object;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moshe.blockchain.db.entity.CurrencyType;
import com.moshe.blockchain.db.entity.Customer;
import com.moshe.blockchain.db.entity.CustomerWallet;

import lombok.Data;

@Data
public class BuyObject {
	
	private CurrencyType currencyType;
	private Long customerId;
	private int amount;

}

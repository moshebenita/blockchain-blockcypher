package com.moshe.blockchain.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ADMIN_WALLET")
@Data
public class AdminWallet {
	
	@Id
	@Column(name = "WALLET_ID")
	@GeneratedValue
	private Long walletId;
	
	@Column(name = "CURRENCY_TYPE")
	private CurrencyType currencyType;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "PUBLIC_KEY")
	private String publicKey;
	
	@Column(name = "PRIVATE_KEY")
	private String privateKey;

}

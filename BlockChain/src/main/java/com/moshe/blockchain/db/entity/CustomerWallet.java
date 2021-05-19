package com.moshe.blockchain.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CUSTOMER_WALLET")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerWallet {
	
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
	
	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="CUSTOMER_ID", nullable=true)
    private Customer customer;

}

package com.moshe.blockchain.db.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="CUSTOMERS")
@Data
public class Customer {
	
	@Id
	@Column(name = "CUSTOMER_ID")
	private Long customerId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
//	@OneToMany(orphanRemoval = false, fetch = FetchType.LAZY)
//	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
//	@JoinColumn(name="WALLET_ID",nullable = true, updatable = true)
//	@JoinTable(
//			 name = "WALLET",
//			 joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
//			 inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID")
//			)
//	private List<CustomerWallet> customerWallets;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer",fetch = FetchType.LAZY)
    private Set<CustomerWallet> customerWallets;
	
	
}

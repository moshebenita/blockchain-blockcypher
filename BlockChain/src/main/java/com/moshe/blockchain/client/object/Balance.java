package com.moshe.blockchain.client.object;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Balance {
	
	private String address;
	private int total_received;
	private int total_sent;
	private int balance;
	private int unconfirmed_balance;
	private int final_balance;
	private int n_tx;
	private int unconfirmed_n_tx;
	private int final_n_tx;

}

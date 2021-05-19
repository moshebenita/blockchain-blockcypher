package com.moshe.blockchain.client.object;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToSignTx {
	
	private Tx tx;
	private List<String> tosign;

}

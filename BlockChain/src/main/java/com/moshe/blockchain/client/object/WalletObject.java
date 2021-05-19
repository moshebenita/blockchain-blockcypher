package com.moshe.blockchain.client.object;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletObject {
	
	private String address;
	
	@JsonProperty("public")
	private String publicKey;
	
	@JsonProperty("private")
	private String privateKey;
	
	private String wif;

}

package com.moshe.blockchain.client.object.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bpi {
	
	@JsonProperty("USD") 
    private CurrencyData usd;
	
    @JsonProperty("GBP") 
    private CurrencyData gbp;
    
    @JsonProperty("EUR") 
    private CurrencyData eUR;

}

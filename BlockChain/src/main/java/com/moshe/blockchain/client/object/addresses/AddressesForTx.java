package com.moshe.blockchain.client.object.addresses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressesForTx {
	private List<Input> inputs;
	private List<Output> outputs;
}

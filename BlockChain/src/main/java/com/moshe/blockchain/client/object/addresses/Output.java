package com.moshe.blockchain.client.object.addresses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Output{
	private List<String> addresses;
	private int value;
}


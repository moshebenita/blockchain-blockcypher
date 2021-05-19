package com.moshe.blockchain.security;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class SignServiceGoImpl implements SignService{

	@Override
	public String signByKey(String datahex, String privateHex) {
		try {
			Process process = Runtime.getRuntime().exec("c:\\git\\btcutils\\signer\\signer.exe "
					+ datahex +  " " + privateHex);
			return new String(process.getInputStream().readAllBytes()).replace("\n", "").replace("\r", "");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

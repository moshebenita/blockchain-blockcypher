package com.moshe.blockchain.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.moshe.blockchain.db.entity.AdminWallet;
import com.moshe.blockchain.db.entity.CurrencyType;
import com.moshe.blockchain.db.entity.Customer;
import com.moshe.blockchain.db.entity.CustomerWallet;

@Repository
public interface WalletAdminRepository extends CrudRepository<AdminWallet, Long>{
	
	@Query("SELECT p FROM AdminWallet p WHERE p.currencyType = :id")
    public List<AdminWallet> findByCurrency(@Param("id") CurrencyType id);

}

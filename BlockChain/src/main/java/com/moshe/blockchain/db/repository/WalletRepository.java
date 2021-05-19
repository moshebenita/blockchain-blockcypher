package com.moshe.blockchain.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.moshe.blockchain.db.entity.Customer;
import com.moshe.blockchain.db.entity.CustomerWallet;

@Repository
public interface WalletRepository extends CrudRepository<CustomerWallet, Long>{
	
	@Query("SELECT p FROM CustomerWallet p WHERE p.customer.id = :id")
    public List<CustomerWallet> findByCustomer(@Param("id") Long id);

}

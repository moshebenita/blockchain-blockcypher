package com.moshe.blockchain.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moshe.blockchain.db.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}

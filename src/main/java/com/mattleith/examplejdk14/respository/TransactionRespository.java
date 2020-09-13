package com.mattleith.examplejdk14.respository;

import com.mattleith.examplejdk14.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRespository extends CrudRepository<Transaction, Long> {
}

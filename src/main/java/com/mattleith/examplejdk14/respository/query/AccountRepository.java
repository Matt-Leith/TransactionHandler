package com.mattleith.examplejdk14.respository.query;

import com.mattleith.examplejdk14.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
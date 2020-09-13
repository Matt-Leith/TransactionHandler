package com.mattleith.examplejdk14.respository;

import com.mattleith.examplejdk14.model.AccountModification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountModificationRepository extends CrudRepository<AccountModification, Long> {
}

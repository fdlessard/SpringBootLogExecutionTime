package io.fdlessard.codebites.timer.repositories;

import io.fdlessard.codebites.timer.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

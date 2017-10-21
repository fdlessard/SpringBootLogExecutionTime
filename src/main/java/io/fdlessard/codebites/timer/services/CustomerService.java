package io.fdlessard.codebites.timer.services;

import io.fdlessard.codebites.timer.domain.Customer;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface CustomerService {

    Customer getCustomerById(long id);

    List<Customer> getAllCustomers();

    List<Customer> getCustomers(List<Long> ids);

    void createCustomer(Customer customer);
}

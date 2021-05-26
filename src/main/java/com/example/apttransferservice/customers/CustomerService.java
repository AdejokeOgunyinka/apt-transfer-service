package com.example.apttransferservice.customers;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByAcctNrAndBankName
                (customer.getAccount_nr(), customer.getBank_name());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException
                    ("This account number with the same bank already exists in the database");
        }
        customerRepository.save(customer);
    }
}

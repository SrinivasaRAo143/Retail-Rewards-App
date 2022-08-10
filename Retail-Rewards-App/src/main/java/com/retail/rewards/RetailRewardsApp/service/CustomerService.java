package com.retail.rewards.RetailRewardsApp.service;

import com.retail.rewards.RetailRewardsApp.model.Customer;
import com.retail.rewards.RetailRewardsApp.repo.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }
    public List<Customer> getAll(){
        return this.customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(Integer customerId){
        return this.customerRepository.findById(customerId);
    }
}

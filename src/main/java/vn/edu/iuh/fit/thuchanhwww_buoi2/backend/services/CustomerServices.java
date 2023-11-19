package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Customer;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServices {
    @Inject
    private CustomerRepository customerRepository;

    @Inject
    public CustomerServices() {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> getCustomerById(long id){
        return customerRepository.getCustomerById(id);
    }
    public boolean add(Customer customer){
        return customerRepository.add(customer);
    }

    public boolean update(Customer customer){
        return customerRepository.update(customer);
    }
    public boolean remove(long id){
        return customerRepository.remove(Customer.class,id);
    }

    public List<Customer> getAll(){
        return customerRepository.getAll(Customer.class);
    }
}

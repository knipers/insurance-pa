package br.com.autoinsurance.quote.services;

import br.com.autoinsurance.quote.dtos.CustomerDTO;
import br.com.autoinsurance.quote.entities.Customer;
import br.com.autoinsurance.quote.exceptions.CustomerException;
import br.com.autoinsurance.quote.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<CustomerDTO> insertOrUpdateCustomer(CustomerDTO dto) {
        Customer customer = prepareCustomerToPersist(customerRepository.findByEmail(dto.getEmail()), dto);
        try {
            customer = customerRepository.save(customer);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
            return ResponseEntity.created(uri).body(new CustomerDTO(customer));
        } catch (Exception e) {
            throw new CustomerException(String.format("Create new customer error: %s", e.getCause()), e);
        }
    }

    private Customer prepareCustomerToPersist(Optional<Customer> databaseValue, CustomerDTO dto) {
        Customer customer = null;
        if (!databaseValue.isPresent()) {
            customer = new Customer(dto);
            customer.setCreated(LocalDateTime.now());
        } else {
            customer = databaseValue.get();
            customer.setCpf(dto.getCpf());
            customer.setName(dto.getName());
            customer.setUpdated(LocalDateTime.now());
        }
        return customer;
    }

    public List<Customer> getAllCustomers() {
        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            throw new CustomerException(String.format("List all customer error: %s", e.getCause()), e);
        }
    }

    public boolean verifyEmailExists(String email) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        return customer.isPresent();
    }
}

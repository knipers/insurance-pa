package br.com.autoinsurance.quote.services;

import br.com.autoinsurance.quote.dtos.AddressDTO;
import br.com.autoinsurance.quote.dtos.CustomerDTO;
import br.com.autoinsurance.quote.entities.Address;
import br.com.autoinsurance.quote.exceptions.AddressException;
import br.com.autoinsurance.quote.exceptions.CustomerException;
import br.com.autoinsurance.quote.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressService {

    AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public List<Address> getAddressByCustomerId(String customerId) {
        return addressRepository.findByIdCustomer(customerId);
    }

    public Address getAddressById(String id) {
        return addressRepository.findById(id).orElse(null);
    }

    public ResponseEntity<AddressDTO> insertAddress(AddressDTO dto) {
        Address newAddress = new Address(dto);
        try {
            newAddress.setCreated(LocalDateTime.now());
            newAddress = addressRepository.save(newAddress);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAddress.getId()).toUri();
            return ResponseEntity.created(uri).body(new AddressDTO(newAddress));
        } catch (Exception e) {
            throw new AddressException(String.format("Create new customer address error: %s", e.getCause()), e);
        }
    }

    public ResponseEntity<?> deleteAddress(String id) {
        try {
            addressRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new AddressException(String.format("Delete customer address error: %s", e.getCause()), e);
        }
    }
}

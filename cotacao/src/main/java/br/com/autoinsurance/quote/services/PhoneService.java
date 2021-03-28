package br.com.autoinsurance.quote.services;

import br.com.autoinsurance.quote.dtos.PhoneDTO;
import br.com.autoinsurance.quote.entities.Phone;
import br.com.autoinsurance.quote.exceptions.AddressException;
import br.com.autoinsurance.quote.exceptions.PhonesException;
import br.com.autoinsurance.quote.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PhoneService {

    PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    public List<Phone> getPhoneByCustomerId(String customerId) {
        return phoneRepository.findByIdCustomer(customerId);
    }

    public Phone getPhoneById(String id) {
        return phoneRepository.findById(id).orElse(null);
    }

    public ResponseEntity<PhoneDTO> insertPhone(PhoneDTO dto) {
        Phone newPhone = new Phone(dto);
        try {
            newPhone.setCreated(LocalDateTime.now());
            newPhone = phoneRepository.save(newPhone);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPhone.getId()).toUri();
            return ResponseEntity.created(uri).body(new PhoneDTO(newPhone));
        } catch (Exception e) {
            throw new PhonesException(String.format("Create new customer phone error: %s", e.getCause()), e);
        }
    }

    public ResponseEntity<?> deletePhone(String id) {
        try {
            phoneRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new AddressException(String.format("Delete customer phone error: %s", e.getCause()), e);
        }
    }
}

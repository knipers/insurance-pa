package br.com.autoinsurance.quote.repositories;

import br.com.autoinsurance.quote.entities.Phone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends MongoRepository<Phone, String> {
    List<Phone> findByIdCustomer(String id);
}

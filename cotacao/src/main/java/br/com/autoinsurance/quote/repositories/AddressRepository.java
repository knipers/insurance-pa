package br.com.autoinsurance.quote.repositories;

import br.com.autoinsurance.quote.entities.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends MongoRepository<Address, String> {
    List<Address> findByIdCustomer(String id);
}

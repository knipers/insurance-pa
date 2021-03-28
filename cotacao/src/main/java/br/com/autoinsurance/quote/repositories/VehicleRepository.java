package br.com.autoinsurance.quote.repositories;

import br.com.autoinsurance.quote.entities.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    List<Vehicle> findByIdCustomer(String id);
}

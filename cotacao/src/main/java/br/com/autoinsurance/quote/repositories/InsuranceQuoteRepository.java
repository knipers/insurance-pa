package br.com.autoinsurance.quote.repositories;

import br.com.autoinsurance.quote.entities.InsuranceQuote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceQuoteRepository extends MongoRepository<InsuranceQuote, String> {

    @Query("{ 'idVehicle' : { $in: ?0  }}")
    List<InsuranceQuote> findAllByVehicleId(List<String> vehicleIds);

}

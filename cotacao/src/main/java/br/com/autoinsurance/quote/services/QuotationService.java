package br.com.autoinsurance.quote.services;

import br.com.autoinsurance.quote.dtos.InsuranceQuoteDTO;
import br.com.autoinsurance.quote.entities.InsuranceQuote;
import br.com.autoinsurance.quote.entities.Vehicle;
import br.com.autoinsurance.quote.exceptions.QuotationException;
import br.com.autoinsurance.quote.repositories.InsuranceQuoteRepository;
import br.com.autoinsurance.quote.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuotationService {

    InsuranceQuoteRepository insuranceQuoteRepository;
    VehicleRepository vehicleRepository;

    @Autowired
    public QuotationService(InsuranceQuoteRepository insuranceQuoteRepository, VehicleRepository vehicleRepository) {
        this.insuranceQuoteRepository = insuranceQuoteRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public List<InsuranceQuote> getAllQuotations() {
        return insuranceQuoteRepository.findAll();
    }

    public ResponseEntity<InsuranceQuoteDTO> insertQuotation(InsuranceQuoteDTO dto) {
         InsuranceQuote newInsuranceQuote = new InsuranceQuote(dto);
        try {
            newInsuranceQuote.setCreated(LocalDateTime.now());
            newInsuranceQuote = insuranceQuoteRepository.save(newInsuranceQuote);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newInsuranceQuote.getId()).toUri();
            return ResponseEntity.created(uri).body(new InsuranceQuoteDTO(newInsuranceQuote));
        } catch (Exception e) {
            throw new QuotationException(String.format("Create new quotation error: %s", e.getCause()), e);
        }
    }

    public List<InsuranceQuote> getAllQuotationsByCustomer(String idCustomer) {
        try {
            List<Vehicle> vehiclesByCustomer = vehicleRepository.findByIdCustomer(idCustomer);
            List<String> vehicleIds = vehiclesByCustomer.stream().map(x -> x.getId()).collect(Collectors.toList());
            List<InsuranceQuote> list = insuranceQuoteRepository.findAllByVehicleId(vehicleIds);
            return list;
        } catch (Exception e) {
            throw new QuotationException(String.format("List quotations by customer error: %s", e.getCause()), e);
        }
    }
}

package br.com.autoinsurance.quote.services;

import br.com.autoinsurance.quote.dtos.VehicleDTO;
import br.com.autoinsurance.quote.entities.Vehicle;
import br.com.autoinsurance.quote.exceptions.VehicleException;
import br.com.autoinsurance.quote.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehicleService {

    VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> getVehicleByCustomerId(String customerId) {
        return vehicleRepository.findByIdCustomer(customerId);
    }

    public Vehicle getVehicleById(String id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public ResponseEntity<VehicleDTO> insertVehicle(VehicleDTO dto) {
        Vehicle newVehicle = new Vehicle(dto);
        try {
            newVehicle.setCreated(LocalDateTime.now());
            newVehicle = vehicleRepository.save(newVehicle);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newVehicle.getId()).toUri();
            return ResponseEntity.created(uri).body(new VehicleDTO(newVehicle));
        } catch (Exception e) {
            throw new VehicleException(String.format("Create new customer vehicle error: %s", e.getCause()), e);
        }
    }

    public ResponseEntity<?> deleteVehicle(String id) {
        try {
            vehicleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new VehicleException(String.format("Delete customer vehicle error: %s", e.getCause()), e);
        }
    }
}

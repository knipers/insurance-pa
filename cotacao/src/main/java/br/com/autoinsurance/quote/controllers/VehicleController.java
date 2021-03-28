package br.com.autoinsurance.quote.controllers;

import br.com.autoinsurance.quote.dtos.PhoneDTO;
import br.com.autoinsurance.quote.dtos.VehicleDTO;
import br.com.autoinsurance.quote.entities.Phone;
import br.com.autoinsurance.quote.entities.Vehicle;
import br.com.autoinsurance.quote.services.PhoneService;
import br.com.autoinsurance.quote.services.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicle")
@Api(tags ={"Customer vehicle service"} )
public class VehicleController {

    private final VehicleService vehicleService;

    VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @ApiOperation("List of all vehicles")
    @GetMapping
    private List<Vehicle> getAllPhones() {
        return vehicleService.getAllVehicles();
    }

    @ApiOperation("List of customer vehicles")
    @GetMapping("/customer/{customerId}")
    private List<Vehicle> getPhonesByCustomerId(@PathVariable String customerId) {
        return vehicleService.getVehicleByCustomerId(customerId);
    }

    @ApiOperation("Get vehicle by ID")
    @GetMapping("/{id}")
    private Vehicle getPhoneById(@PathVariable String id) {
        return vehicleService.getVehicleById(id);
    }

    @ApiOperation("Register a new vehicle")
    @PostMapping
    private ResponseEntity<VehicleDTO> postAddress(@RequestBody VehicleDTO dto) {
        return vehicleService.insertVehicle(dto);
    }

    @ApiOperation("Delete a customer vehicle")
    @DeleteMapping("/{id}")
    private ResponseEntity<?> deletePhone(@PathVariable String id) {
        return vehicleService.deleteVehicle(id);
    }
}

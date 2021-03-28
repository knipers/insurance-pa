package br.com.autoinsurance.quote.controllers;

import br.com.autoinsurance.quote.dtos.PhoneDTO;
import br.com.autoinsurance.quote.entities.Phone;
import br.com.autoinsurance.quote.services.PhoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phone")
@Api(tags ={"Customer phone service"} )
public class PhoneController {

    private final PhoneService phoneService;

    PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @ApiOperation("List of all phones")
    @GetMapping
    private List<Phone> getAllPhones() {
        return phoneService.getAllPhones();
    }

    @ApiOperation("List of customer phones")
    @GetMapping("/customer/{customerId}")
    private List<Phone> getPhonesByCustomerId(@PathVariable String customerId) {
        return phoneService.getPhoneByCustomerId(customerId);
    }

    @ApiOperation("Get phone by ID")
    @GetMapping("/{id}")
    private Phone getPhoneById(@PathVariable String id) {
        return phoneService.getPhoneById(id);
    }

    @ApiOperation("Register a new address")
    @PostMapping
    private ResponseEntity<PhoneDTO> postAddress(@RequestBody PhoneDTO dto) {
        return phoneService.insertPhone(dto);
    }

    @ApiOperation("Delete a customer phone")
    @DeleteMapping("/{id}")
    private ResponseEntity<?> deletePhone(@PathVariable String id) {
        return phoneService.deletePhone(id);
    }
}

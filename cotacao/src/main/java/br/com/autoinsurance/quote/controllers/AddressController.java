package br.com.autoinsurance.quote.controllers;

import br.com.autoinsurance.quote.dtos.AddressDTO;
import br.com.autoinsurance.quote.dtos.CustomerDTO;
import br.com.autoinsurance.quote.entities.Address;
import br.com.autoinsurance.quote.services.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
@Api(tags ={"Customer address service"} )
public class AddressController {

    private final AddressService addressService;

    AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @ApiOperation("List of all address")
    @GetMapping
    private List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @ApiOperation("List of customer addresses")
    @GetMapping("/customer/{customerId}")
    private List<Address> getAddressByCustomerId(@PathVariable String customerId) {
        return addressService.getAddressByCustomerId(customerId);
    }

    @ApiOperation("Get address by ID")
    @GetMapping("/{id}")
    private Address getAddressById(@PathVariable String id) {
        return addressService.getAddressById(id);
    }

    @ApiOperation("Register a new address")
    @PostMapping
    private ResponseEntity<AddressDTO> postAddress(@RequestBody AddressDTO dto) {
        return addressService.insertAddress(dto);
    }

    @ApiOperation("Delete a customer address")
    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteAddress(@PathVariable String id) {
        return addressService.deleteAddress(id);
    }
}

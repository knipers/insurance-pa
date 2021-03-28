package br.com.autoinsurance.quote.controllers;

import br.com.autoinsurance.quote.dtos.CustomerDTO;
import br.com.autoinsurance.quote.entities.Customer;
import br.com.autoinsurance.quote.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@Api(tags ={"Customer service"} )
public class CustomerController {

    private final CustomerService customerService;

    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation("List of customers")
    @GetMapping
    private List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @ApiOperation("Register a new customer")
    @PostMapping
    private ResponseEntity<CustomerDTO> postCustomer(@RequestBody CustomerDTO dto) {
        return customerService.insertOrUpdateCustomer(dto);
    }

    @ApiOperation("Check exists customer by e-mail")
    @GetMapping("/check-email")
    private boolean verifyEmailExists(@RequestParam String email) {
        return customerService.verifyEmailExists(email);
    }
}

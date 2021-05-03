package br.com.autoinsurance.quote.controllers;

import br.com.autoinsurance.quote.dtos.InsuranceQuoteDTO;
import br.com.autoinsurance.quote.entities.InsuranceQuote;
import br.com.autoinsurance.quote.enums.QuotationTypes;
import br.com.autoinsurance.quote.services.QuotationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quotation")
@Api(tags ={"Insurance quote service"} )
public class QuotationController {

    private final QuotationService quotationService;

    QuotationController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    @ApiOperation("List of all quotations")
    @GetMapping
    private List<InsuranceQuote> getAllQuotations() {
        return quotationService.getAllQuotations();
    }

    @ApiOperation("Register a new vehicle quotation")
    @PostMapping("vehicle")
    private ResponseEntity<InsuranceQuoteDTO> postInsuranceVehicleQuote(@RequestBody InsuranceQuoteDTO dto) {
        return quotationService.insertQuotation(dto, QuotationTypes.VEHICLE);
    }

    @ApiOperation("Register a new vehicle quotation")
    @PostMapping("life")
    private ResponseEntity<InsuranceQuoteDTO> postInsuranceLifeQuote(@RequestBody InsuranceQuoteDTO dto) {
        return quotationService.insertQuotation(dto, QuotationTypes.LIFE);
    }


    @ApiOperation("Register a new vehicle quotation")
    @PostMapping("house")
    private ResponseEntity<InsuranceQuoteDTO> postInsuranceHouseQuote(@RequestBody InsuranceQuoteDTO dto) {
        return quotationService.insertQuotation(dto, QuotationTypes.HOUSE);
    }


    @ApiOperation("List of all quotations by customer")
    @GetMapping("/customer/{idCustomer}")
    private List<InsuranceQuote> getAllQuotationsByCustomer(@PathVariable String idCustomer) {
        return quotationService.getAllQuotationsByCustomer(idCustomer);
    }


}

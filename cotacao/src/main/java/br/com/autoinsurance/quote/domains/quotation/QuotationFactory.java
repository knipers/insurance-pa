package br.com.autoinsurance.quote.domains.quotation;

import br.com.autoinsurance.quote.dtos.InsuranceQuoteDTO;
import br.com.autoinsurance.quote.entities.InsuranceQuote;
import br.com.autoinsurance.quote.enums.QuotationTypes;

public class QuotationFactory {
    public static InsuranceQuote createQuotation(QuotationTypes type, InsuranceQuoteDTO dto) {
        switch (type) {
            case VEHICLE:
                return new VehicleQuotation().getQuote(dto);
            case LIFE:
                return new LifeQuotation().getQuote(dto);
            case HOUSE:
                return new HouseQuotation().getQuote(dto);
            default:
                throw new RuntimeException("Tipo de cotação de seguro não foi definida.");
        }
    }
}

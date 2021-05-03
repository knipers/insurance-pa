package br.com.autoinsurance.quote.domains.quotation;

import br.com.autoinsurance.quote.dtos.InsuranceQuoteDTO;
import br.com.autoinsurance.quote.entities.InsuranceQuote;
import br.com.autoinsurance.quote.enums.QuotationTypes;

public class VehicleQuotation implements IQuotation {

    private static String EMAIL_MESSAGE = "Seus dados foram enviados para cotação, entraremos em contato em breve.";

    @Override
    public InsuranceQuote getQuote(InsuranceQuoteDTO dto) {
        InsuranceQuote insuranceQuote = new InsuranceQuote(dto);
        insuranceQuote.setType(QuotationTypes.VEHICLE);
        return insuranceQuote;
    }

    @Override
    public String getDefaultEmailMessage() {
        return EMAIL_MESSAGE;
    }
}

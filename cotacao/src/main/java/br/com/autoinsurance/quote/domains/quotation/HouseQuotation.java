package br.com.autoinsurance.quote.domains.quotation;

import br.com.autoinsurance.quote.dtos.InsuranceQuoteDTO;
import br.com.autoinsurance.quote.entities.InsuranceQuote;
import br.com.autoinsurance.quote.enums.QuotationTypes;

public class HouseQuotation implements IQuotation {

    private static String EMAIL_MESSAGE = "Não estamos atendendo cotações residenciais no momento. Guardaremos seus dados e entraremos em contato no futuro";

    @Override
    public InsuranceQuote getQuote(InsuranceQuoteDTO dto) {
        InsuranceQuote insuranceQuote = new InsuranceQuote(dto);
        insuranceQuote.setType(QuotationTypes.HOUSE);
        return insuranceQuote;
    }

    @Override
    public String getDefaultEmailMessage() {
        return EMAIL_MESSAGE;
    }
}

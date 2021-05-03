package br.com.autoinsurance.quote.domains.quotation;

import br.com.autoinsurance.quote.dtos.InsuranceQuoteDTO;
import br.com.autoinsurance.quote.entities.InsuranceQuote;

public interface IQuotation {
    public InsuranceQuote getQuote(InsuranceQuoteDTO dto);
    public String getDefaultEmailMessage();
}

package br.com.autoinsurance.quote.entities;

import br.com.autoinsurance.quote.base.BaseEntity;
import br.com.autoinsurance.quote.dtos.InsuranceQuoteDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document
public class InsuranceQuote extends BaseEntity {
    private Map<String, String> parameters;
    private String idVehicle;

    public InsuranceQuote(Map<String, String> parameters, String idVehicle) {
        this.parameters = parameters;
        this.idVehicle = idVehicle;
    }

    public InsuranceQuote(InsuranceQuoteDTO dto) {
        this.parameters = dto.getParameters();
        this.idVehicle = dto.getIdVehicle();
    }

    public InsuranceQuote() {
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }
}

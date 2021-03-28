package br.com.autoinsurance.quote.dtos;

import br.com.autoinsurance.quote.entities.InsuranceQuote;
import br.com.autoinsurance.quote.entities.Vehicle;

import java.time.LocalDateTime;
import java.util.Map;

public class InsuranceQuoteDTO {
    private String id;
    private Map<String, String> parameters;
    private String idVehicle;
    private LocalDateTime created;
    private LocalDateTime updated;

    public InsuranceQuoteDTO() {
    }

    public InsuranceQuoteDTO(String id, Map<String, String> parameters, String idVehicle, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.parameters = parameters;
        this.idVehicle = idVehicle;
        this.created = created;
        this.updated = updated;
    }

    public InsuranceQuoteDTO(InsuranceQuote iq) {
        this.id = iq.getId();
        this.parameters = iq.getParameters();
        this.idVehicle = iq.getIdVehicle();
        this.created = iq.getCreated();
        this.updated = iq.getUpdated();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
